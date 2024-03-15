package com.controller;


import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.DormManager;
import com.model.User;
import com.service.DormManagerService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/dormManager")
public class DormManagerController {

    @Resource
    private DormManagerService dormManagerService;

    /**
     * 宿管登录
     */
    @RequestLog
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        DormManager dormManager = dormManagerService.selectDormManagerById(user.getId());
        if (dormManager == null) return Result.unauthorized("用户名或密码错误");
        if (dormManager.getPassword().equals(user.getPassword())) {
            //存入session
            session.setAttribute("Identity", "dormManager");
            session.setAttribute("User", dormManager);
            return Result.success(dormManager);
        } else {
            return Result.unauthorized("用户名或密码错误");
        }
    }

    /**
     * 宿管添加
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody DormManager dormManager) {
        int i = dormManagerService.addNewDormManager(dormManager);
        return i == 1 ? Result.success() : Result.error("添加失败");
    }

    /**
     * 宿管信息更新
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody DormManager dormManager) {
        int i = dormManagerService.updateNewDormManager(dormManager);
        return i == 1 ? Result.success() : Result.error("更新失败");
    }

    /**
     * 宿管删除
     */
    @RequestLog
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        int i = dormManagerService.deleteDormManager(id);
        return i == 1 ? Result.success() : Result.error("删除失败");
    }

    /**
     * 宿管查找
     */
    @RequestLog
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        PageInfo<DormManager> pageInfo = dormManagerService.find(pageNum, pageSize, search);
        return pageInfo != null ? Result.success(pageInfo) : Result.error("查询失败");
    }


}
