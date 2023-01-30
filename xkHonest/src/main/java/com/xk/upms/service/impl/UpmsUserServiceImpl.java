package com.xk.upms.service.impl;

import com.xk.common.util.MD5Utils;
import com.xk.common.util.NotFoundException;
import com.xk.common.util.XkBeanUtils;
import com.xk.upms.dao.mapper.UpmsRoleMapper;
import com.xk.upms.dao.mapper.UpmsUserMapper;
import com.xk.upms.dao.repository.UpmsRoleRepository;
import com.xk.upms.dao.repository.UpmsUserRepository;
import com.xk.upms.dao.repository.UpmsUserRoleRepository;
import com.xk.upms.model.bo.UpmsUserReq;
import com.xk.upms.model.bo.UpmsUserSaveReq;
import com.xk.upms.model.dto.UpmsUserRoleExample;
import com.xk.upms.model.po.UpmsRole;
import com.xk.upms.model.po.UpmsUser;
import com.xk.upms.model.po.UpmsUserRole;
import com.xk.upms.model.vo.UpmsUserDetailResp;
import com.xk.upms.model.vo.UpmsUserIndexResp;
import com.xk.upms.model.vo.UpmsUserSaveResp;
import com.xk.upms.service.UpmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * UpmsUserService 實現
 * Created by yuan on 2022/06/10
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UpmsUserServiceImpl implements UpmsUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    private UpmsUserRepository upmsUserRepository;
    @Autowired
    private UpmsRoleRepository upmsRoleRepository;
    @Autowired
    private UpmsUserRoleRepository upmsUserRoleRepository;
    @Autowired
    private UpmsUserMapper upmsUserMapper;
    @Autowired
    private UpmsRoleMapper upmsRoleMapper;

    @Override
    public List list(UpmsUserReq resources) {
        List<UpmsUserIndexResp> resultList = new ArrayList<>();

//        List<UpmsUser> resultEntities = upmsUserRepository.findAll();
        List<UpmsUserRoleExample> resultDtos = upmsUserMapper.selectAllwithRole();
        resultList = XkBeanUtils.copyListProperties(resultDtos, UpmsUserIndexResp::new);

        return resultList;
    }

    @Override
    public UpmsUserDetailResp selectDeatilById(long id) {
        UpmsUserDetailResp result = new UpmsUserDetailResp();

        UpmsUser entity = upmsUserRepository.findById(id).get();
        if (entity == null) {
            throw new NotFoundException("查無使用者");
        }
        BeanUtils.copyProperties(entity, result);

        List<UpmsRole> roleList = upmsRoleMapper.selectAllByUserId(id);
        result.setRoleList(roleList);

        return result;
    }

    @Override
    public UpmsUserSaveResp create(UpmsUserSaveReq resources) {
        UpmsUserSaveResp result = new UpmsUserSaveResp();

        UpmsUser req = new UpmsUser();
        BeanUtils.copyProperties(resources, req);

        UpmsUser checkUser = new UpmsUser();
        checkUser = upmsUserRepository.findByUsername(req.getUsername());
        if (null != checkUser) {
            throw new NotFoundException("帳號名已存在！");
        }

        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        req.setSalt(salt);
        req.setPassword(MD5Utils.code(req.getPassword() + req.getSalt()));
        req.setCreateTime(new Date());
        UpmsUser entity = upmsUserRepository.save(req);

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public UpmsUserSaveResp update(Long id, UpmsUserSaveReq resources) {
        UpmsUserSaveResp result = new UpmsUserSaveResp();

        UpmsUser req = new UpmsUser();
        BeanUtils.copyProperties(resources, req);
        UpmsUser entity = upmsUserRepository.save(req);

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public void delete(Long id) {
        upmsUserRepository.deleteById(id);
    }

    @Override
    public void deleteByPrimaryKeys(String ids) {
        String[] idArray = ids.split("-");
        for (String idStr : idArray) {
            Long id = Long.valueOf(idStr);
            upmsUserRepository.deleteById(id);
        }
    }

    @Override
    public UpmsUserSaveResp selectByPrimaryKey(long id) {
        UpmsUserSaveResp result = new UpmsUserSaveResp();

        UpmsUser entity = upmsUserRepository.findById(id).get();

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public List findAllUsersByRoleId(Long roleId) {
        List<UpmsUserSaveResp> resultList = new ArrayList<UpmsUserSaveResp>();

        // check
        Optional<UpmsRole> role = upmsRoleRepository.findById(roleId);
        if (role == null) {
            return null;
        }

        List<UpmsUserRole> urList = upmsUserRoleRepository.findByRoleId(role.get().getId());
        List<Long> roleIds = new ArrayList<>();
        for (UpmsUserRole ur : urList) {
            roleIds.add(ur.getId());
        }

        List resultEntities = upmsUserRepository.findAllById(roleIds);
//        BeanUtils.copyProperties(resultEntities, resultList);
        resultList = XkBeanUtils.copyListProperties(resultEntities, UpmsUserSaveResp::new);

        return resultList;
    }

}
