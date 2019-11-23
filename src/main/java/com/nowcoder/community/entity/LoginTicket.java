package com.nowcoder.community.entity;

import java.util.Date;

/**
 * @author Song Weiwei
 * @date 2019-11-23
 * 登陆成功凭证
 */
public class LoginTicket {

    private int id; //编号
    private int userId; //用户id
    private String ticket;  //凭证码
    private int status; //状态 0:有效  1:无效
    private Date expired;   //到期日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "LoginTicket{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", status=" + status +
                ", expired=" + expired +
                '}';
    }
}
