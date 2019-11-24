package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Song Weiwei
 * @date 2019-11-24
 * 自定义注解：登录状态检查（登陆后才能访问）
 */

@Target(ElementType.METHOD) //自定义注解作用在方法上
@Retention(RetentionPolicy.RUNTIME) //自定义注解在运行时有效
public @interface LoginRequired {



}
