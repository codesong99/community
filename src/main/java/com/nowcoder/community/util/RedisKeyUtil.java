package com.nowcoder.community.util;

/**
 * @author Song Weiwei
 * @date 2019-12-02
 * 生成RedisKey的工具类：点赞
 * 我收到的赞
 * 关注、取消关注
 * 优化登录模块-验证码
 * 优化登录模块-登录凭证
 * 优化登录模块-缓存用户信息
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity"; //对实体（帖子、评论）的赞以前缀开头
    private static final String PREFIX_USER_LIKE = "like:user";     //用户收到的赞 的前缀
    private static final String PREFIX_FOLLOWEE = "followee";       //被关注的实体
    private static final String PREFIX_FOLLOWER = "follower";       //粉丝
    private static final String PREFIX_KAPTCHA = "kaptcha";         // 验证码
    private static final String PREFIX_TICKET = "ticket";           // 登录凭证
    private static final String PREFIX_USER = "user";               // 用户信息

    // 生成 某个实体的赞 的key
    // like:entity:entityType:entityId -> set(userId)
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某个用户的赞
    // like:user:userId -> int
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    // 某个用户关注的实体
    // followee:userId:entityType -> zset(entityId, now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT +userId + SPLIT + entityType;
    }

    // 某个用户拥有的粉丝
    // follower:entityType:entityId -> zset(userId, now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    // 登录验证码
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    // 登录的凭证
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }

    // 用户
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }
}
