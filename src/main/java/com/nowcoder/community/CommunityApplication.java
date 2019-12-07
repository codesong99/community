package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommunityApplication {

	@PostConstruct
	public void init() {
		// 解决netty启动冲突的问题
		// see Netty4Utils.class line39 不调用setAvailableProcessors -> NettyRuntime.class line34不报错
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}

//版本信息： 开发社区搜索功能 20191207
/*
*

发现问题：自己给自己造成的“系统通知”无法显示，500错误，message未找到，可能是系统通知没有写入
* */