package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Song Weiwei
 * @date 2019-11-25
 * 敏感词过滤器测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void setSensitiveFilter() {
        String text = "※赌博这里可以赌博，这里可以嫖娼，可以吸##毒，可以开票，哈哈哈！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }

}
