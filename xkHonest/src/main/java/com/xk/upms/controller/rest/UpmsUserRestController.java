package com.xk.upms.controller.rest;

import com.xk.common.base.BaseRepostitory;
import com.xk.upms.model.bo.UpmsSystemSaveReq;
import com.xk.upms.model.bo.UpmsUserSaveReq;
import com.xk.upms.model.vo.UpmsUserSaveResp;
import com.xk.upms.service.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 用户 RestController
 * Created by yuan on 2022/06/10
 */
@RestController
@Api("用户管理api")
@RequestMapping("/api/manage/user")
public class UpmsUserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserRestController.class);

    @Autowired
    private BaseRepostitory baseRepostitory;
    @Autowired
    private UpmsUserService upmsUserService;

    @ApiOperation(value = "用戶列表")
    @GetMapping("/list")
    public Object list() {
        return upmsUserService.list(null);
    }

    @ApiOperation(value = "用戶欄位表頭")
    @GetMapping("/page_head")
    public Object page_head() {
        return baseRepostitory.queryTableComent("upms_system");
    }

    /**
     * init()
     */
    @GetMapping("/init")
    public String init() {
        UpmsUserSaveReq data = new UpmsUserSaveReq();
        data.setCreateBy("init system");

        data.setSalt("truck");
        data.setAvatar(null);
        data.setPhone("0987654321");
        data.setLocked(Byte.valueOf("0"));

        data.setUsername("admin");
        data.setPassword("123456");
        data.setRealname("系統管理員");
        data.setEmail("admin@gmail.com");
        data.setSex(Byte.valueOf("0"));
        upmsUserService.create(data);

        data.setUsername("user001");
        data.setPassword("123456");
        data.setRealname("使用人員1");
        data.setEmail("user001@gmail.com");
        data.setSex(Byte.valueOf("1"));
        upmsUserService.create(data);
        return "OK";
    }

}

