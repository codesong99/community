package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Song Weiwei
 * @date 2019-11-20
 * 封装登陆时用的两个方法
 */
public class CommunityUtil {

    //生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密
    //hello -> abc123def456
    //hello + 3e4a8(salt) -> abc123def456abc  salt字段提高安全性
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
