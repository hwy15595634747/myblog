package com.hwy.blog.service;

import com.hwy.blog.dao.pojo.SysUser;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.UserVo;

public interface SysUserService  {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据Account查询用户信息
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);

}
