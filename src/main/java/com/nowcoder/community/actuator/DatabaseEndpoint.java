package com.nowcoder.community.actuator;

import com.nowcoder.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Song Weiwei
 * @date 2019-12-21
 * 数据库监控端点
 */

@Component
@Endpoint(id = "database")
public class DatabaseEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseEndpoint.class);

    @Autowired
    private DataSource dataSource;

    // 通过连接池访问数据库
    @ReadOperation  //GET请求访问
    private String checkConnection() {
        try (
                Connection conn = dataSource.getConnection();
        ){
            return CommunityUtil.getJSONString(0, "获取数据库连接成功！");
        } catch (SQLException e) {
            logger.error("获取连接失败：" + e.getMessage());
            return CommunityUtil.getJSONString(0, "获取数据库连接失败！");
        }
    }

}
