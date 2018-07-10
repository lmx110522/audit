package com.nyist.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "document", schema = "aduilt", catalog = "")
public class DocumentEntity {
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
        DocumentEntity that = (DocumentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dname, that.dname) &&
                Objects.equals(fileUrl, that.fileUrl) &&
                Objects.equals(imgUrl, that.imgUrl) &&
                Objects.equals(grouping, that.grouping) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dname, fileUrl, imgUrl, grouping, updateTime, isOk);
    }
}
