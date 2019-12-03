package com.nowcoder.community.util;

/**
 * @author Song Weiwei
 * @date 2019-12-02
 * 生成RedisKey的工具类：点赞
 * 我收到的赞
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity"; //对实体（帖子、评论）的赞以前缀开头
    private static final String PREFIX_USER_LIKE = "like:user";     //用户收到的赞 的前缀

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

}
