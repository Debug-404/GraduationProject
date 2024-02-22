package com.controller;

import com.model.Notice;
import com.service.NoticeService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeAction {

    @Resource
    NoticeService noticeService;

    /**
     * 公告查找
     */
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        List<Notice> list = noticeService.find(pageNum, pageSize, search);
        return Result.success(list);

    }

    /**
     * 公告添加
     */
    @PostMapping("/add")
    public Result add(@RequestBody Notice notice) {
        int i = noticeService.addNewNotice(notice);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 公告更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody Notice notice) {
        int i = noticeService.updateNewNotice(notice);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 公告删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        int i = noticeService.deleteNotice(id);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }

    /**
     * 首页公告展示
     */
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
