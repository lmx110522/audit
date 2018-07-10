package com.nyist.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_module", schema = "aduilt", catalog = "")
public class UserModuleEntity {
    private String id;
    private String content;
    private Integer score;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
        UserModuleEntity that = (UserModuleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(score, that.score) &&
                Objects.equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, score, isOk);
    }
}
