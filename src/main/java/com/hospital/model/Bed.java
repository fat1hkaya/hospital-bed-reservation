package com.hospital.model;

public class Bed {

    private int id;
    private String roomNo;
    private String bedNo;
    private BedStatus status;

    public Bed(int id, String roomNo, String bedNo, BedStatus status){
        this.id = id;
        this.roomNo = roomNo;
        this.bedNo = bedNo;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getRoomNo(){
        return roomNo;
    }

    public String getBedNo(){
        return bedNo;
    }

    public BedStatus getStatus(){
        return status;
    }

    public void setStatus(BedStatus status){
        this.status = status;
    }
    @Override
    public String toString() { return "Oda: "+ roomNo +" Yatak: " + bedNo; }
}
