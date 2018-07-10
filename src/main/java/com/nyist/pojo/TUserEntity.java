package com.nyist.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "aduilt", catalog = "")
public class TUserEntity {
    private String id;
    private String username;
    private String password;
    private Integer role;
    private Integer grouping;
    private String phone;
    private Integer isOk;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "grouping")
    public Integer getGrouping() {
        return grouping;
    }

    public void setGrouping(Integer grouping) {
        this.grouping = grouping;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "is_ok")
    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUserEntity that = (TUserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(grouping, that.grouping) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, role, grouping, phone, isOk);
    }
}
