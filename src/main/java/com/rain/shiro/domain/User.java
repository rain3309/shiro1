package com.rain.shiro.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sys_user")
public class User extends BaseModel implements Serializable {

    private String id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String address;
    private String wechat;
    private String qq;

    @Id
    @Column(name = "f_id",unique = true)
    @TableGenerator(name = "tg_sys_user",table = "t_id_table",pkColumnName = "f_table",valueColumnName = "f_id_value",pkColumnValue = "sys_user",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "tg_sys_user")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "f_username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "f_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "f_salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    @Column(name = "f_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "f_address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "f_wechat")
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    @Column(name = "f_qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
