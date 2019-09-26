package com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain;

public class SafetyRectification {
    private int safetyId;
    private String areaName;
    private String safetyRequire;
    private String initiatorName;
    private String safetyDeadline;
    private String safetyPhotos;
    private String gradeName;
    private String rectifyName;
    private String reviewName;

    private String safetyCreateTime;
    private String hiddenName;
    private String constructionName;
    private String safetyDescribe;
    private String initiatorTime;

    private String rectifyResult;
    private String rectifyPhotos;

    private String reviewPath;
    private String reviewOpinions;
    private String reviewResult;

    private String makeName;

    public int getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(int safetyId) {
        this.safetyId = safetyId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSafetyRequire() {
        return safetyRequire;
    }

    public void setSafetyRequire(String safetyRequire) {
        this.safetyRequire = safetyRequire;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getSafetyDeadline() {
        return safetyDeadline;
    }

    public void setSafetyDeadline(String safetyDeadline) {
        this.safetyDeadline = safetyDeadline;
    }

    public String getSafetyPhotos() {
        return safetyPhotos;
    }

    public void setSafetyPhotos(String safetyPhotos) {
        this.safetyPhotos = safetyPhotos;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getRectifyName() {
        return rectifyName;
    }

    public void setRectifyName(String rectifyName) {
        this.rectifyName = rectifyName;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getSafetyCreateTime() {
        return safetyCreateTime;
    }

    public void setSafetyCreateTime(String safetyCreateTime) {
        this.safetyCreateTime = safetyCreateTime;
    }

    public String getHiddenName() {
        return hiddenName;
    }

    public void setHiddenName(String hiddenName) {
        this.hiddenName = hiddenName;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getSafetyDescribe() {
        return safetyDescribe;
    }

    public void setSafetyDescribe(String safetyDescribe) {
        this.safetyDescribe = safetyDescribe;
    }

    public String getInitiatorTime() {
        return initiatorTime;
    }

    public void setInitiatorTime(String initiatorTime) {
        this.initiatorTime = initiatorTime;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public String getRectifyResult() {
        return rectifyResult;
    }

    public void setRectifyResult(String rectifyResult) {
        this.rectifyResult = rectifyResult;
    }

    public String getRectifyPhotos() {
        return rectifyPhotos;
    }

    public void setRectifyPhotos(String rectifyPhotos) {
        this.rectifyPhotos = rectifyPhotos;
    }

    public String getReviewPath() {
        return reviewPath;
    }

    public void setReviewPath(String reviewPath) {
        this.reviewPath = reviewPath;
    }

    public String getReviewOpinions() {
        return reviewOpinions;
    }

    public void setReviewOpinions(String reviewOpinions) {
        this.reviewOpinions = reviewOpinions;
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    @Override
    public String toString() {
        return "SafetyRectification{" +
                "safetyId=" + safetyId +
                ", areaName='" + areaName + '\'' +
                ", safetyRequire='" + safetyRequire + '\'' +
                ", initiatorName='" + initiatorName + '\'' +
                ", safetyDeadline='" + safetyDeadline + '\'' +
                ", safetyPhotos='" + safetyPhotos + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", rectifyName='" + rectifyName + '\'' +
                ", reviewName='" + reviewName + '\'' +
                ", safetyCreateTime='" + safetyCreateTime + '\'' +
                ", hiddenName='" + hiddenName + '\'' +
                ", constructionName='" + constructionName + '\'' +
                ", safetyDescribe='" + safetyDescribe + '\'' +
                ", initiatorTime='" + initiatorTime + '\'' +
                ", rectifyResult='" + rectifyResult + '\'' +
                ", rectifyPhotos='" + rectifyPhotos + '\'' +
                ", reviewPath='" + reviewPath + '\'' +
                ", reviewOpinions='" + reviewOpinions + '\'' +
                ", reviewResult='" + reviewResult + '\'' +
                ", makeName='" + makeName + '\'' +
                '}';
    }
}
