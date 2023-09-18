package edu.mum.cs.cs425.demowebapps.eregistrar.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {

    @Id
    private long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cGPA;
    private LocalDate dateOfEnrolment;
    private String isInternational;


    public Student(long studentId, String studentNumber, String firstName, String middleName,
                   String lastName, double cGPA, int year, int month, int day, String isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cGPA = cGPA;
        this.dateOfEnrolment = LocalDate.of(year, month, day);
        this.isInternational = isInternational;
    }

    public Student() {

    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getcGPA() {
        return cGPA;
    }

    public void setcGPA(double cGPA) {
        this.cGPA = cGPA;
    }

    public LocalDate getDateOfEnrolment() {
        return dateOfEnrolment;
    }


    public void setDateOfEnrolment(LocalDate dateOfEnrolment) {
        this.dateOfEnrolment = dateOfEnrolment;
    }
}
