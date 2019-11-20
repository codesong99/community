package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Song Weiwei
 * @date 2019-11-15
 * 测试用，可删除
 */

@Repository("alphaHibernate")
public class AlphaHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
