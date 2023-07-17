package com.example.BlogMode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private Integer empl_Id;
    private String empl_Name;
    private String empl_Designation;
    private String empl_Email;
    private String empl_Address;

    public Employee() {
    }

    public Employee(Integer empl_Id, String empl_Name, String empl_Designation, String empl_Email, String empl_Address) {
        this.empl_Id = empl_Id;
        this.empl_Name = empl_Name;
        this.empl_Designation = empl_Designation;
        this.empl_Email = empl_Email;
        this.empl_Address = empl_Address;
    }

    public Integer getEmpl_Id() {
        return empl_Id;
    }

    public void setEmpl_Id(Integer empl_Id) {
        this.empl_Id = empl_Id;
    }

    public String getEmpl_Name() {
        return empl_Name;
    }

    public void setEmpl_Name(String empl_Name) {
        this.empl_Name = empl_Name;
    }

    public String getEmpl_Designation() {
        return empl_Designation;
    }

    public void setEmpl_Designation(String empl_Designation) {
        this.empl_Designation = empl_Designation;
    }

    public String getEmpl_Email() {
        return empl_Email;
    }

    public void setEmpl_Email(String empl_Email) {
        this.empl_Email = empl_Email;
    }

    public String getEmpl_Address() {
        return empl_Address;
    }

    public void setEmpl_Address(String empl_Address) {
        this.empl_Address = empl_Address;
    }
}
