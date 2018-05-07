package com.rain.shiro.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseModel implements Serializable {

    private static final String YES = "yes";
    private Date createTime;
    private Date modifyTime;
    private String operator;
    private String enabled;
    private int version;

    @PreUpdate
    public void preUpdate(){
        setModifyTime(new Date());
    }

    @PrePersist
    public void prePersist(){
        Date date = new Date();
        setCreateTime(date);
        setEnabled(YES);
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Column(name = "f_operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Pattern(regexp = "YES|NO")
    @Column(name = "f_enabled")
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Version
    @Column(name = "f_version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
