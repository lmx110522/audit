package com.nyist.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/7/9/009.
 */
@Entity
@Table(name = "document", schema = "aduti", catalog = "")
public class DocumentEntity {
    private int id;
    private String dname;
    private String url;
    private String grouping;
    private Timestamp updatetime;
    private String isok;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
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
    @Column(name = "grouping")
    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    @Basic
    @Column(name = "updatetime")
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
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

        DocumentEntity that = (DocumentEntity) o;

        if (id != that.id) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (grouping != null ? !grouping.equals(that.grouping) : that.grouping != null) return false;
        if (updatetime != null ? !updatetime.equals(that.updatetime) : that.updatetime != null) return false;
        if (isok != null ? !isok.equals(that.isok) : that.isok != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (grouping != null ? grouping.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        result = 31 * result + (isok != null ? isok.hashCode() : 0);
        return result;
    }
}
