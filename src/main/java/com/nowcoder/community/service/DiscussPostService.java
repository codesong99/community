package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @author Song Weiwei
 * @date 2019-11-17
 * 显示讨论区帖子
 * 发布帖子
 * 帖子详情
 * 更新帖子评论数量
 * 置顶、加精、删除
 * 更新帖子分数
 */
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    // 查询帖子
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit, int orderMode) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit, orderMode);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    // 发布帖子
    public int addDiscussPost(DiscussPost post) {
        if (post == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        // 转义HTML标记 如<div>hello world -> &lt;div&gt;hello world
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
        post.setContent(HtmlUtils.htmlEscape(post.getContent()));
        // 过滤敏感词
        post.setTitle(sensitiveFilter.filter(post.getTitle()));
        post.setContent(sensitiveFilter.filter(post.getContent()));

        return discussPostMapper.insertDiscussPost(post);
    }

    // 帖子详情
    public DiscussPost findDiscussPostById(int id) {
        return discussPostMapper.selectDiscussPostById(id);
    }

    // 更新帖子评论数量
    public int updateCommentCount(int id, int commentCount) {
        return discussPostMapper.updateCommentCount(id, commentCount);
    }

    // 更新帖子类型
    public int updateType(int id, int type) {
        return discussPostMapper.updateType(id, type);
    }

    // 更新帖子状态
    public int updateStatus(int id, int status) {
        return discussPostMapper.updateStatus(id, status);
    }

    // 更新帖子分数
    public int updateScore(int id, double score) {
        return discussPostMapper.updateScore(id, score);
    }
}
