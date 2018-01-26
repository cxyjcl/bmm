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
public class Train{

    @Id
    @GeneratedValue
    private Integer id;

    private String trainDate;

    private String trainLesson;

    private String trainLevel;

    private String trainPlace;

    private String teacher;

    private Integer registerInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainLesson() {
        return trainLesson;
    }

    public void setTrainLesson(String trainLesson) {
        this.trainLesson = trainLesson;
    }

    public String getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }

    public String getTrainPlace() {
        return trainPlace;
    }

    public void setTrainPlace(String trainPlace) {
        this.trainPlace = trainPlace;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getRegisterInfoId() {
        return registerInfoId;
    }

    public void setRegisterInfoId(Integer registerInfoId) {
        this.registerInfoId = registerInfoId;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainDate='" + trainDate + '\'' +
                ", trainLesson='" + trainLesson + '\'' +
                ", trainLevel='" + trainLevel + '\'' +
                ", trainPlace='" + trainPlace + '\'' +
                ", teacher='" + teacher + '\'' +
                ", registerInfoId=" + registerInfoId +
                '}';
    }
}
