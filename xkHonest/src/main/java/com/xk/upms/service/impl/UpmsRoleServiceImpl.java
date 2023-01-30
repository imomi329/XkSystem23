package com.xk.upms.service.impl;

import com.xk.upms.dao.repository.UpmsRoleRepository;
import com.xk.upms.model.bo.UpmsRoleReq;
import com.xk.upms.model.bo.UpmsRoleSaveReq;
import com.xk.upms.model.po.UpmsRole;
import com.xk.upms.model.po.UpmsUser;
import com.xk.upms.model.vo.UpmsRoleSaveResp;
import com.xk.upms.model.vo.UpmsUserSaveResp;
import com.xk.upms.service.UpmsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * UpmsRoleService 實現
 * Created by yuan on 2022/06/24
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UpmsRoleServiceImpl implements UpmsRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

    @Autowired
    private UpmsRoleRepository upmsRoleRepository;

    @Override
    public List list(UpmsRoleReq resources) {
        return upmsRoleRepository.findAll();
    }

    @Override
    public UpmsRoleSaveResp create(UpmsRoleSaveReq resources) {
        UpmsRoleSaveResp result = new UpmsRoleSaveResp();

        UpmsRole req = new UpmsRole();
        BeanUtils.copyProperties(resources, req);

        long time = System.currentTimeMillis();
        req.setOrders(time);
        req.setCreateTime(new Date());
        UpmsRole entity = upmsRoleRepository.save(req);

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public UpmsRoleSaveResp update(Long id, UpmsRoleSaveReq resources) {
        UpmsRoleSaveResp result = new UpmsRoleSaveResp();

        UpmsRole req = new UpmsRole();
        BeanUtils.copyProperties(resources, req);
        UpmsRole entity = upmsRoleRepository.save(req);

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public void delete(Long id) {
        upmsRoleRepository.deleteById(id);
    }

    @Override
    public void deleteByPrimaryKeys(String ids) {
        String[] idArray = ids.split("-");
        for (String idStr : idArray) {
            Long id = Long.valueOf(idStr);
            upmsRoleRepository.deleteById(id);
        }
    }

    @Override
    public UpmsRoleSaveResp selectByPrimaryKey(long id) {
        UpmsRoleSaveResp result = new UpmsRoleSaveResp();

        UpmsRole entity = upmsRoleRepository.findById(id).get();

        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public UpmsRole selectByName(String name) {
        return upmsRoleRepository.findByName(name);
    }

}
