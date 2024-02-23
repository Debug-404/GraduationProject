package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.model.Admin;
import com.model.User;
import com.service.AdminService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Resource
    AdminService adminService;

    /**
     * 管理员登录
     */
    @PassToken
    @RequestLog
    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user) {
        Admin admin = adminService.selectAdminById(user.getId());
        if (admin.getPassword().equals(user.getPassword())) {
            return Result.success("登录成功");
        } else return Result.unauthorized("账号或者密码错误，请重新登录");
    }

    /**
     * 管理员信息更新
     */
    @PutMapping("/update")
    @RequestLog
    public Result update(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin) == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }


    @RequestLog
    @PostMapping("/intoNotice")
    public Result intoNotice(@RequestBody Map<String, Object> map) {
        adminService.intoNotice(map);
        return Result.success();
    }

    @RequestLog
    @PostMapping("/getNotice/{currentPage}")
    public Result getNotice(@PathVariable int currentPage) {
        return Result.success(adminService.findByLimit(currentPage, 5));
    }
}
