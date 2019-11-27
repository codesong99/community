package com.nowcoder.community;

import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Song Weiwei
 * @date 2019-11-26
 * 事务管理测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class TransactionTests {

    @Autowired
    private AlphaService alphaService;

    // 声明式事务
    @Test
    public void testSave1() {
        Object obj = alphaService.save1();
        System.out.println(obj);
    }

    // 编程式事务
    @Test
    public void testSave2() {
        Object obj = alphaService.save2();
        System.out.println(obj);
    }

}
