package com.nowcoder.community.config;

import com.nowcoder.community.quartz.AlphaJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author Song Weiwei
 * @date 2019-12-18
 * quartz配置类
 */

// 配置 -> 数据库 -> 调用
@Configuration
public class QuartzConfig {

    // FactoryBean可简化Bean的实例化过程：
    // 1.通过FactoryBean封装了Bean的实例化过程.
    // 2.将FactoryBean装配到Spring容器里.
    // 3.将FactoryBean注入给其他的Bean
    // 4.该Bean得到的是FactoryBean所管理的对象实例

    //配置JobDetail
    //@Bean
    public JobDetailFactoryBean alphaJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);    //管理的类
        factoryBean.setName("alphaJob");            //任务的名字
        factoryBean.setGroup("alphaJobGroup");      //Job组名
        factoryBean.setDurability(true);            //持久保存
        factoryBean.setRequestsRecovery(true);      //可恢复
        return factoryBean;
    }

    //配置Trigger(SimpleTriggerFactoryBean，CronTriggerFactoryBean)
    //@Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);   //传入JobDetail实例
        factoryBean.setName("alphaTrigger");        //Trigger的名字
        factoryBean.setGroup("alphaTriggerGroup");  //Trigger组名
        factoryBean.setRepeatInterval(3000);        //任务频率
        factoryBean.setJobDataMap(new JobDataMap());//存储Job状态的对象
        return factoryBean;
    }
}
