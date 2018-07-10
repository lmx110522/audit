package com.nyist.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authority", schema = "aduilt", catalog = "")
public class AuthorityEntity {
    private String id;
    private String pname;
    private String url;
    private Integer sorter;
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
    @Column(name = "pname")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "sorter")
    public Integer getSorter() {
        return sorter;
    }

    public void setSorter(Integer sorter) {
        this.sorter = sorter;
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
        AuthorityEntity that = (AuthorityEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pname, that.pname) &&
                Objects.equals(url, that.url) &&
                Objects.equals(sorter, that.sorter) &&
                Objects.equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, pname, url, sorter, isOk);
    }
}
