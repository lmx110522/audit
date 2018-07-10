package com.nyist.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_authority", schema = "aduilt", catalog = "")
public class RoleAuthorityEntity {
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
        RoleAuthorityEntity that = (RoleAuthorityEntity) o;
        return id == that.id &&
                Objects.equals(role, that.role) &&
                Objects.equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, isOk);
    }
}
