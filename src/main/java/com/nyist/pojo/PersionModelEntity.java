package com.nyist.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/9/009.
 */
@Entity
@Table(name = "persion_model", schema = "aduti", catalog = "")
public class PersionModelEntity {
    private int id;
    private String centon;
    private Integer score;
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
    @Column(name = "centon")
    public String getCenton() {
        return centon;
    }

    public void setCenton(String centon) {
        this.centon = centon;
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

        PersionModelEntity that = (PersionModelEntity) o;

        if (id != that.id) return false;
        if (centon != null ? !centon.equals(that.centon) : that.centon != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (isok != null ? !isok.equals(that.isok) : that.isok != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (centon != null ? centon.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (isok != null ? isok.hashCode() : 0);
        return result;
    }
}
