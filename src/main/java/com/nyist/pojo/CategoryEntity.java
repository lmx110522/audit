package com.nyist.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/9/009.
 */
@Entity
@Table(name = "category", schema = "aduti", catalog = "")
public class CategoryEntity {
    private int id;
    private String sname;
    private String content;
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
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (sname != null ? !sname.equals(that.sname) : that.sname != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (isok != null ? !isok.equals(that.isok) : that.isok != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (isok != null ? isok.hashCode() : 0);
        return result;
    }
}
