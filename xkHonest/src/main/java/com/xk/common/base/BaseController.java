package com.xk.common.base;

import com.xk.upms.service.UpmsPermissionService;
import com.xk.upms.service.UpmsSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Created by yuan on 2022/05/24
 */
@Controller
public class BaseController {

    private static final String DIR_INDEX = "/";
    public static final String ADMIN_INDEX = "/admin/index";

    @Autowired
    private UpmsSystemService upmsSystemService;
    @Autowired
    private UpmsPermissionService upmsPermissionService;

    public Model info(Model model, String path) {
        model.addAttribute("aside_system", upmsSystemService.list());
//        model.addAttribute("left_tree", upmsPermissionService.buildTree(upmsPermissionService.selectBySystemIdAndRole(1, 1)));
        model.addAttribute("left_tree", upmsPermissionService.buildTree(upmsPermissionService.list()));
        model.addAttribute("info", upmsPermissionService.findOneByUri(path));
        return model;
    }

}

