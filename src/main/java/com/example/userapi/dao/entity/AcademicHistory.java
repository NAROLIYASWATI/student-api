package com.example.userapi.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AcademicHistory {

    @Id
    private long academicHistoryId;

    @Column
    private String session;

    @Column
    private  Integer semester;

    @Column
    private Float SGPA;

    @Column
    private  String status;

    @Column
    private  String result;

    public long getAcademicHistoryId() {
        return academicHistoryId;
    }

    public void setAcademicHistoryId(long academicHistoryId) {
        this.academicHistoryId = academicHistoryId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Float getSGPA() {
        return SGPA;
    }

    public void setSGPA(Float SGPA) {
        this.SGPA = SGPA;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
