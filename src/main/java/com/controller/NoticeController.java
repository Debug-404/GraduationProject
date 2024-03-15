package com.controller;

import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.Notice;
import com.service.NoticeService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    /**
     * 公告查找
     */
    @RequestLog
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search) {
        PageInfo<Notice> pageInfo = noticeService.find(pageNum, pageSize, search);
        return Result.success(pageInfo);
    }

    /**
     * 公告添加
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody Notice notice) {
        int i = noticeService.addNewNotice(notice);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 公告更新
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Notice notice) {
        int i = noticeService.updateNewNotice(notice);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 公告删除
     */
    @RequestLog
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        int i = noticeService.deleteNotice(id);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }

    /**
     * 首页公告展示
     */
    @RequestLog
    @GetMapping("/homePageNotice")
    public Result homePageNotice() {
        List<Notice> list = noticeService.homePageNotice();
        if (list != null) {
            return Result.success(list);
        } else {
            return Result.error("首页公告查询失败");
        }
    }
}
