package com.nyist.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module", schema = "aduilt", catalog = "")
public class ModuleEntity {
    private String id;
    private String mname;
    private String content;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        ModuleEntity that = (ModuleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(mname, that.mname) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mname, content);
    }
}
