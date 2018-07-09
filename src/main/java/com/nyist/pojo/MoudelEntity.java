package com.nyist.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/9/009.
 */
@Entity
@Table(name = "moudel", schema = "aduti", catalog = "")
public class MoudelEntity {
    private int id;
    private String mname;
    private String content;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mname")
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoudelEntity that = (MoudelEntity) o;

        if (id != that.id) return false;
        if (mname != null ? !mname.equals(that.mname) : that.mname != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mname != null ? mname.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
