package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	//传入Spring容器，并用applicationContext记录下来
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);	//输出Spring容器

		//获取bean
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());	//输出MyBatis这个bean

		alphaDao = applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());	//输出Hibernate这个bean

	}

	@Test
	public void testBeanManagement() {
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired	//自动注入对象。通过依赖注入管理bean
	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI() {	//依赖注入
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}

}
