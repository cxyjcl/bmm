package org.dmm.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@Entity
@DynamicUpdate(true)
public class Job extends BaseEntity{

    @Id
    @GeneratedValue
    private Integer id;

    private String category;

    private String judge;

    private String observer;

    private String fourthOfficial;

    private String headJudge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getFourthOfficial() {
        return fourthOfficial;
    }

    public void setFourthOfficial(String fourthOfficial) {
        this.fourthOfficial = fourthOfficial;
    }

    public String getHeadJudge() {
        return headJudge;
    }

    public void setHeadJudge(String headJudge) {
        this.headJudge = headJudge;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", judge='" + judge + '\'' +
                ", observer='" + observer + '\'' +
                ", fourthOfficial='" + fourthOfficial + '\'' +
                ", headJudge='" + headJudge + '\'' +
                '}';
    }
}
