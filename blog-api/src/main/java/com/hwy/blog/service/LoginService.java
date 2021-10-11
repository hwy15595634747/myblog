package com.hwy.blog.service;

import com.hwy.blog.dao.pojo.SysUser;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.LoginParams;

public interface LoginService {

    //登陆功能
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);

    /**
     * 注册
     * @param loginParams
     * @return
     */
    Result register(LoginParams loginParams);
}
