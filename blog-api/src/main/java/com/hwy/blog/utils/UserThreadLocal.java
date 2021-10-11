package com.hwy.blog.utils;

import com.hwy.blog.dao.pojo.SysUser;
import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class UserThreadLocal {

    private UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void  put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }

}
