package com.springboot.weekly.entity;

import java.util.Date;

//周报内容
public class Weekly {
    private Integer id;
    private String studentNumber;
    private String weeklyId;
    private String learnProgress;
    private String dailyProgress;
    private Integer hour;
    private String timeShare;
    private String expression;
    private Date date;
    private String reviewComments;
    private String filename;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(String weeklyId) {
        this.weeklyId = weeklyId;
    }

    public String getLearnProgress() {
        return learnProgress;
    }

    public void setLearnProgress(String learnProgress) {
        this.learnProgress = learnProgress;
    }

    public String getDailyProgress() {
        return dailyProgress;
    }

    public void setDailyProgress(String dailyProgress) {
        this.dailyProgress = dailyProgress;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getTimeShare() {
        return timeShare;
    }

    public void setTimeShare(String timeShare) {
        this.timeShare = timeShare;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Weekly{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", weeklyId='" + weeklyId + '\'' +
                ", learnProgress='" + learnProgress + '\'' +
                ", dailyProgress='" + dailyProgress + '\'' +
                ", hour=" + hour +
                ", timeShare='" + timeShare + '\'' +
                ", expression='" + expression + '\'' +
                ", date=" + date +
                ", reviewComments='" + reviewComments + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
