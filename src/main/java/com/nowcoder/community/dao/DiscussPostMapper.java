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
 * 置顶、加精、删除
 * 更新帖子分数
 */

@Mapper
public interface DiscussPostMapper {

    // 查询帖子
    // 参数不是必须，动态SQL
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);   //userId为0：查询所有 1：按用户查询  orderMode默认为0：默认排序 1：热度排序

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

    // 更改帖子类型
    int updateType(int id, int type);

    // 更改帖子状态
    int updateStatus(int id, int status);

    // 更新帖子分数
    int updateScore(int id, double score);

}
