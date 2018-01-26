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
public class Experience{

    @Id
    @GeneratedValue
    private Integer id;

    private String experienceDate;

    private String ballTeam;

    private String remark;

    private Integer registerInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExperienceDate() {
        return experienceDate;
    }

    public void setExperienceDate(String experienceDate) {
        this.experienceDate = experienceDate;
    }

    public String getBallTeam() {
        return ballTeam;
    }

    public void setBallTeam(String ballTeam) {
        this.ballTeam = ballTeam;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRegisterInfoId() {
        return registerInfoId;
    }

    public void setRegisterInfoId(Integer registerInfoId) {
        this.registerInfoId = registerInfoId;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", experienceDate='" + experienceDate + '\'' +
                ", ballTeam='" + ballTeam + '\'' +
                ", remark='" + remark + '\'' +
                ", registerInfoId=" + registerInfoId +
                '}';
    }
}
