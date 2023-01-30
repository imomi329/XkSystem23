package com.xk.upms.service;

import com.xk.upms.model.bo.UpmsRoleReq;
import com.xk.upms.model.bo.UpmsRoleSaveReq;
import com.xk.upms.model.po.UpmsRole;
import com.xk.upms.model.vo.UpmsRoleSaveResp;

import java.util.List;

/**
 * UpmsRoleService 接口
 * Created by yuan on 2022/06/24
 */
public interface UpmsRoleService {

    List list(UpmsRoleReq resources);

    UpmsRoleSaveResp create(UpmsRoleSaveReq resources);

    UpmsRoleSaveResp update(Long id, UpmsRoleSaveReq resources);

    void delete(Long id);

    void deleteByPrimaryKeys(String ids);

    UpmsRoleSaveResp selectByPrimaryKey(long id);

    UpmsRole selectByName(String name);
}
