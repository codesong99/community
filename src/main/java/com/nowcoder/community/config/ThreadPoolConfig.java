package com.nowcoder.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Song Weiwei
 * @date 2019-12-18
 * 线程池配置类
 */

@Configuration
@EnableScheduling   //启动定时任务
@EnableAsync
public class ThreadPoolConfig {
}
