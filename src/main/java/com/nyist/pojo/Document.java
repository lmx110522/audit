package com.nyist.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/7/11/011.
 */
@Entity
public class Document {
    private String id;
    private String dname;
    private String fileUrl;
    private String imgUrl;
    private Integer grouping;
    private Timestamp updateTime;
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
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "file_url")
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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

        Document document = (Document) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (dname != null ? !dname.equals(document.dname) : document.dname != null) return false;
        if (fileUrl != null ? !fileUrl.equals(document.fileUrl) : document.fileUrl != null) return false;
        if (imgUrl != null ? !imgUrl.equals(document.imgUrl) : document.imgUrl != null) return false;
        if (grouping != null ? !grouping.equals(document.grouping) : document.grouping != null) return false;
        if (updateTime != null ? !updateTime.equals(document.updateTime) : document.updateTime != null) return false;
        if (isOk != null ? !isOk.equals(document.isOk) : document.isOk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (fileUrl != null ? fileUrl.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (grouping != null ? grouping.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        return result;
    }
}
