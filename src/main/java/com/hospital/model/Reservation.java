package com.hospital.model;

import java.time.LocalDate;

public class Reservation{

    private int id;
    private Patient patient;
    private Bed bed;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(int id , Patient patient,Bed bed,LocalDate startDate,LocalDate endDate){

        this.id = id;
        this.patient =patient;
        this.bed = bed;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId(){
        return id;
    }

    public Patient getPatient(){
        return patient;
    }

    public Bed getBed(){
        return bed;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
    @Override
    public String toString() {
        return patient.getName() + ": " +bed.getRoomNo()+" - "+ startDate + " / " + endDate;
    }

}
