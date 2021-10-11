package com.hwy.blog.controller;

import com.hwy.blog.dao.pojo.SysUser;
import com.hwy.blog.utils.UserThreadLocal;
import com.hwy.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test() {
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);

        return Result.success(null);
    }
}
