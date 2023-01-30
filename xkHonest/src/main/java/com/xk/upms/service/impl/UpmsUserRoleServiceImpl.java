package com.xk.upms.service.impl;

import com.xk.upms.service.UpmsUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UpmsUserRoleService 實現
 * Created by yuan on 2022/06/24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UpmsUserRoleServiceImpl implements UpmsUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserRoleServiceImpl.class);

    @Override
    public void role(String[] roleIds, int id) {

    }

}