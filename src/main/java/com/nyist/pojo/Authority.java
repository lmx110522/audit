package com.nyist.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/7/13/013.
 */
@Entity
public class Authority {
    private String id;
    private String aname;
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
    @Column(name = "aname")
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
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

        Authority authority = (Authority) o;

        if (id != null ? !id.equals(authority.id) : authority.id != null) return false;
        if (aname != null ? !aname.equals(authority.aname) : authority.aname != null) return false;
        if (url != null ? !url.equals(authority.url) : authority.url != null) return false;
        if (sorter != null ? !sorter.equals(authority.sorter) : authority.sorter != null) return false;
        if (isOk != null ? !isOk.equals(authority.isOk) : authority.isOk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aname != null ? aname.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (sorter != null ? sorter.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        return result;
    }
}
