package za.ac.cput.domain;

/*
 * Student.java
 * author Chante Lewis : 216118395
 */

import java.io.Serializable;

public class Student implements Serializable {

    private String studentID;
    private String fullname;
    private String surname;
    private String email;
    private String password;
    private int course;
    private int studentRecords;


    public Student(String studentID, String fullname, String surname, String email, String password, int course) {
        this.studentID = studentID;
        this.fullname = fullname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.course = course;
    }


    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullname='" + fullname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
