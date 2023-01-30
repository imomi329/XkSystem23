package com.xk.admin.controller.web;

import com.xk.common.base.BaseController;
import com.xk.upms.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 後台管理頁面
 * Created by yuan on 2022/06/10
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController extends BaseController {

    private static final String DIR_INDEX = "admin/";
    private static final String INDEX = DIR_INDEX + "auth/login";
    private static final String REDIRECT_ADDR = "redirect:/truck/login";

    @Autowired
    private UpmsUserService userService;

    @GetMapping
    public String loginPage(Model model) {
//        this.info(model, this.getClass().getAnnotation(RequestMapping.class).value()[0]);
        return INDEX;
    }

    @GetMapping("/index")
    public String index(Model model) {
        this.info(model, this.getClass().getAnnotation(RequestMapping.class).value()[0]);
        return DIR_INDEX + "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes) {
//        User user = userService.checkUser(username, password);
//        if(user != null) {
//            user.setPassword(null);
//            session.setAttribute("user", user);
//            return DIR_INDEX + "admin/index";
//        } else {
//            attributes.addFlashAttribute("message", "用戶名和密碼錯誤");
            return REDIRECT_ADDR;
//        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return REDIRECT_ADDR;
    }

}
