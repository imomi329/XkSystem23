package com.xk.upms.service;

import com.xk.upms.model.bo.UpmsUserReq;
import com.xk.upms.model.bo.UpmsUserSaveReq;
import com.xk.upms.model.vo.UpmsUserDetailResp;
import com.xk.upms.model.vo.UpmsUserSaveResp;

import java.util.List;

/**
 * UpmsUserService 接口
 * Created by yuan on 2022/06/10
 */
public interface UpmsUserService {

    List list(UpmsUserReq resources);

    UpmsUserDetailResp selectDeatilById(long id);

    UpmsUserSaveResp create(UpmsUserSaveReq resources);

    UpmsUserSaveResp update(Long id, UpmsUserSaveReq resources);

    void delete(Long id);

    void deleteByPrimaryKeys(String ids);

    UpmsUserSaveResp selectByPrimaryKey(long id);

    List findAllUsersByRoleId(Long roleId);
}
