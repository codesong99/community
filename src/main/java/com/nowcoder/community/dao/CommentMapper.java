package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Song Weiwei
 * @date 2019-11-26
 * 显示评论
 */

@Mapper
public interface CommentMapper {

    // 查询评论
    List<Comment> selectCommentByEntity(int entityType, int entityId, int offset, int limit);

    // 查询评论数量
    int selectCountByEntity(int entityType, int entityId);


}
