package com.jyou.thinker.ws.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO: 用户
 * @author wgbing
 * @date 2019-08-15 19:55
 */
@Data
@Entity
@Table(name = "sys_user")
public class User extends BaseEntity implements Serializable {

    /** 用户名 */
    @Column(nullable = false,unique = true)
    private String userName;

    /** 登录密码 */
    @Column(nullable = false)
    private String password;

    /** 是否超级管理员 */
    @Column
    private Boolean superAdmin;

    /** 昵称 */
    @Column
    private String nickName;

    /** 性别 0=女；1=男 */
    @Column
    private Integer sex;

    /** 手机号 */
    @Column
    private String phone;

    /** 邮箱 */
    @Column
    private String email;

    /** 头像 */
    @Column
    private String avatar;

    /** 备注 */
    @Column
    private String remark;

    /** 上次登录时间 */
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /** 上次登录所用IP */
    @Column
    private String lastLoginIp;

    /** 是否启用 */
    @Column
    private Boolean enable;

    /** 是否删除 */
    @Column
    private Boolean deleted;

}
