package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author Song Weiwei
 * @date 2019-11-15
 * 测试用，可删除
 */

@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "MyBatis";
    }
}
