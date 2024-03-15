package com.controller;

import com.annotation.RequestLog;
import com.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/main")
public class MainController {

    /**
     * 获取身份信息
     */
    @RequestLog
    @GetMapping("/loadIdentity")
    public Result loadIdentity(HttpSession session) {
        Object identity = session.getAttribute("Identity");
        return identity != null ? Result.success(identity) : Result.error("加载失败");
    }

    /**
     * 获取个人信息
     */
    @RequestLog
    @GetMapping("/loadUserInfo")
    public Result loadUserInfo(HttpSession session) {
        Object User = session.getAttribute("User");
        return User != null ? Result.success(User) : Result.error("加载失败");
    }

    /**
     * 退出登录
     */
    @RequestLog
    @GetMapping("/signOut")
    public Result signOut(HttpSession session) {
        session.removeAttribute("User");
        session.removeAttribute("Identity");
        return Result.success();
    }
}
