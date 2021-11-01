package lk.pamo.royal.entity;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    private String regNo;
    private String regDate;
    private String regFee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cID", referencedColumnName = "code", nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sID", referencedColumnName = "id", nullable = false)
    private Student student;

    public Registration() {
    }

    public Registration(String regNo, String regDate, String regFee, Course course, Student student) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.course = course;
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }
}
