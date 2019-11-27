package com.nowcoder.community.util;

/**
 * @author Song Weiwei
 * @date 2019-11-20
 * 常量接口 （激活账户）
 * 常量接口 （登陆账号）
 * 常量接口 （显示评论）
 */
public interface CommunityConstant {

    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 重复激活
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * 激活失败
     */
    int ACTIVATION_FAILURE = 2;

    /**
     * 默认状态下 登陆凭证的超时时间
      */
    int DEFAULY_EXPIRED_SECONDS = 3600 * 12; //12小时

    /**
     * 记住状态下 登陆凭证的超时时间
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100; //100天

    /**
     * 实体类型：帖子     *
     */
    int ENTITY_TYPE_POST = 1;

    /**
     * 实体类型：评论     *
     */
    int ENTITY_TYPE_COMMENT = 2;

}
