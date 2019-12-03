package com.nowcoder.community.service;

import com.nowcoder.community.util.RedisKeyUtil;
import io.lettuce.core.RedisURI;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

/**
 * @author Song Weiwei
 * @date 2019-12-02
 * 点赞功能
 * 我收到的赞
 */

@Service
public class LikeService {

    @Autowired
    private RedisTemplate redisTemplate;

    // 点赞 （重构 保证点赞、收到的赞的事务性）
    public void like(int userId, int entityType, int entityId, int entityUserId) {

        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
                String userLikeKey = RedisKeyUtil.getUserLikeKey(entityUserId);
                // 判断用户是否点过赞
                boolean isMember = operations.opsForSet().isMember(entityLikeKey, userId);

                operations.multi();         //启用事务

                if (isMember) { // 点过赞
                    operations.opsForSet().remove(entityLikeKey, userId);   //取消赞
                    operations.opsForValue().decrement(userLikeKey);        //赞-1
                } else {        // 没点过赞
                    operations.opsForSet().add(entityLikeKey, userId);      //点赞
                    operations.opsForValue().increment(userLikeKey);        //赞+1
                }

                return operations.exec();   //结束事务
            }
        });
    }

    // 查询实体点赞的数量
    public long findEntityLikeCount(int entityType, int entityId) {
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
        return redisTemplate.opsForSet().size(entityLikeKey);
    }

    // 查询某人对某实体的点赞状态
    public int findEntityLikeStatus(int userId, int entityType, int entityId) {
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
        return redisTemplate.opsForSet().isMember(entityLikeKey, userId) ? 1 : 0;
   }

   // 查询某个用户获得的赞
    public int findUserLikeCount(int userId) {
        String userLikeKey = RedisKeyUtil.getUserLikeKey(userId);
        Integer count = (Integer) redisTemplate.opsForValue().get(userLikeKey);
        return count == null ? 0 : count.intValue();
    }

}
