package com.getarrays.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity //this sure that this class is mapped to any database that we configured on the classpath

public class Employee implements Serializable { //it helps java class transform into
    // different types of stream such as json
    @Id//I NEED A PRIMARY KEY HOW TO GENERATE THIS INFORMATION IS BELOW
    @GeneratedValue (strategy = GenerationType.AUTO) //WE MAY NOT TO USE IT AUTO, IDENTITY, SEQUENCE, TABLE KULLANILABİLİR BAK FARKLAARI NEYMİŞ
    @Column(nullable = false, updatable = false)//specify column infotrmatıon nullable ve updatable false olursa hiçbirşey güncellenmez
    // ve silinmez özel şeyler için kullanılabilir
    //lombok işi kolaylaştırıyor ancak videoda aktif kullanmadık constructor oluşturmamızı hızlandırıyor
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
    public Employee(){}

    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }
    public Employee(String name, String email, String employeeCode) {
        this.name = name;
        this.email = email;
        this.employeeCode = employeeCode;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    @Override //to see location of object
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}



