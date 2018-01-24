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
public class UserInfo extends BaseEntity{
    @Id
    @GeneratedValue
    private Integer id;

    private String realName;

    private String birthday;

    private String nativePlace;

    private String Association;

    private String height;

    private String weight;

    private String cardNumber;

    private String education;

    private String politicalStatus;

    private String foreignLanguage;

    private String phoneNumber;

    private String otherNumber;

    private String company;

    private String currentLevel;

    private String LevelDate;

    private String email;

    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getAssociation() {
        return Association;
    }

    public void setAssociation(String association) {
        Association = association;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getLevelDate() {
        return LevelDate;
    }

    public void setLevelDate(String levelDate) {
        LevelDate = levelDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", Association='" + Association + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", education='" + education + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", foreignLanguage='" + foreignLanguage + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", otherNumber='" + otherNumber + '\'' +
                ", company='" + company + '\'' +
                ", currentLevel='" + currentLevel + '\'' +
                ", LevelDate='" + LevelDate + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
