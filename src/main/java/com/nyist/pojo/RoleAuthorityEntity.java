package com.nyist.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/9/009.
 */
@Entity
@Table(name = "role_authority", schema = "aduti", catalog = "")
public class RoleAuthorityEntity {
    private int id;
    private String role;
    private String isok;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "isok")
    public String getIsok() {
        return isok;
    }

    public void setIsok(String isok) {
        this.isok = isok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleAuthorityEntity that = (RoleAuthorityEntity) o;

        if (id != that.id) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (isok != null ? !isok.equals(that.isok) : that.isok != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (isok != null ? isok.hashCode() : 0);
        return result;
    }
}
