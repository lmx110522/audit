package com.nyist.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/11/011.
 */
@Entity
@Table(name = "role_authority", schema = "aduilt", catalog = "")
public class RoleAuthority {
    private int id;
    private Integer role;
    private Integer isOk;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        RoleAuthority that = (RoleAuthority) o;

        if (id != that.id) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (isOk != null ? !isOk.equals(that.isOk) : that.isOk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        return result;
    }
}