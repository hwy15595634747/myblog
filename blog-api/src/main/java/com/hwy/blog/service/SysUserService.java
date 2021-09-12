package com.hwy.blog.service;

import com.hwy.blog.dao.pojo.SysUser;

public interface SysUserService  {

    SysUser findUserById(Long id);
}
