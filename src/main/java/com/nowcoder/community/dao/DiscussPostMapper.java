package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Song Weiwei
 * @date 2019-11-17
 * 查询帖子
 * 增加帖子
 * 帖子详情
 * 更新帖子评论数量
 */

@Mapper
public interface DiscussPostMapper {

    //参数不是必须，动态SQL
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);   //userId为0：查询所有 1：按用户查询

    //@Param注解用于给参数取别名
    //如果只有几个参数，并且在SQL的<if>里使用，则必须加别名
    //即动态SQL如果只有一个参数，则参数必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);

    // 增加帖子
    int insertDiscussPost(DiscussPost discussPost);

    // 帖子详情
    DiscussPost selectDiscussPostById(int id);

    // 更新帖子评论数量
    int updateCommentCount(int id, int commentCount);

}
