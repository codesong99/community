package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Song Weiwei
 * @date 2019-11-29
 * 私信列表
 */

@Mapper
public interface MessageMapper {

    // 查询当前用户的会话列表,针对每个会话 只返回一条最新的私信
    List<Message> selectConversations(int userId, int offset, int limit);

    // 查询当前用户的会话数量
    int selectConversationCount(int userId);

    // 查询某个会话包含的私信列表
    List<Message> selectLetters(String conversationId, int offset, int limit);

    // 查询某个会话包含的私数量
    int selectLetterCount(String conversationId);

    // 查询未读私信数量(所有会话 & 单个会话)
    int selectLetterUnreadCount(int userId, String conversationId);

}
