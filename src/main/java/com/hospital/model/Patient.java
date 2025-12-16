package com.hospital.model;

public class Patient{

    private int id;
    private String name;
    private String surname;
    private String tcNo;

    public Patient(int id, String name, String surname, String tcNo){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tcNo = tcNo;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getTcNo(){
        return tcNo;
    }
}
