package cn.com.pojo;

import java.io.Serializable;

public class UserKey implements Serializable {
    private String host;

    private String user;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}