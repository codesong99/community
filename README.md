# community 牛课社区项目
#### （V1.0、V2.1、V2.2）2019年11月20日首次提交：
完成社区首页，发送邮件，开发注册功能
#### （V2.4）2019年11月22日：
（V2.3：为会话管理，介绍cookie和session区别）

完成生成验证码功能
#### V2.5 2019年11月23日：
增加登陆、退出登陆功能
#### V2.6 2019年11月23日
显示登陆信息.
#### V2.7 V2.8 2019年11月24日
增加账号设置（修改头像）、检查登陆状态功能
#### V3.1 V3.2 2019年11月26日
过滤敏感词、发布帖子
#### V3.3 V3.4 V3.5 2019年11月27日
增加 帖子详情、事务管理、显示评论 功能
#### V3.6 2019年11月28日
增加 添加评论 功能
#### V3.7 2019年11月30日
增加 私信列表（及私信详情）功能
#### V3.8 V3.9 V3.10 2019年12月1日
增加 发送私信、统一异常处理、统一记录日志 功能
#### V4.2 2019年12月2日
（V4.1为Redis入门，介绍Reids的概念）

Spring整合Redis
#### V4.3 2019年12月2日
增加 点赞 功能
#### V4.4 2019年12月3日
增加 我收到的赞 功能

修改 帖子详情页面发帖人名称显示错误 的问题

不仅可以从首页进入用户个人主页，也可以从帖子详情页面进入个人主页
#### V4.5 2019年12月3日
增加 关注、取消关注 功能
#### V4.6 2019年12月4日
增加 关注列表、粉丝列表 功能
#### V4.7 2019年12月4日
优化登录模块
#### V5.1 (V5.2) 2019年12月4日
阻塞队列测试
#### V5.3 2019年12月5日
spring整合kafka
#### V5.4 2019年12月5日
发送系统通知
#### V5.５ 2019年12月６日
显示系统通知
#### (V6.1) V6.2 2019年12月7日
Spring整合Elasticsearch
#### V6.3 2019年12月7日
开发社区搜索功能
#### (V7.1) V7.2 2019年12月13日
权限控制

解决了没有关注类消息时，消息通知详情出现错误的问题
#### V7.3 2019年12月17日
置顶、加精、删除
#### V7.4 V7.5 2019年12月17日
网站数据统计
#### V7.6 2019年12月18日
任务调度和执行 示例
#### V7.7 2019年12月18日
实现热帖排行功能
#### V7.8 2019年12月19日
生成长图
#### V7.9 2019年12月20日
将文件上传至云服务器
#### V7.10 2019年12月21日
优化网站性能，启动本地缓存
#### V8.1 2019年12月21日
解决了分页功能“第i页”无法使用的问题

使用Actuator进行项目监控

（V8.1未git，与V8.2一同上传）
#### V8.2 2019年12月23日
简单修改前端样式
#### V1.0 2019年12月24日 正式版本
 **正式版本**：
 
 修改了前端样式：尾部
 可在开发模式、生产模式之间切换
#### V1.1 2020年1月6日
域名备案完成，正式上线版本
#### V1.2 2020年2月
迁移到新电脑，配置环境，修改相关配置
#### V1.2.2 2020年3月23日
修改主页底部样式，更新七牛云服务器

**项目启动说明**：
①注意切换develop和produce模式；
②在Windows平台，需启动Elasticsearch、zookeeper、kafka，并保证kafka中有“test”、“comment”、“like”、“follow”、“publish”、“delete”、“share”共7个topic；
③部署到云服务器时，使用centOS7.6，同样要保证kafka中以创建相应主题。