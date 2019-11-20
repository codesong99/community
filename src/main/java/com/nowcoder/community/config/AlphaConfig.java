package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author Song Weiwei
 * @date 2019-11-15
 */
@Configuration  //配置类
public class AlphaConfig {

    @Bean   //这个方法返回的对象将被装在到容器中，名字就是方法名
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM--dd HH:00:ss");
    }

}
