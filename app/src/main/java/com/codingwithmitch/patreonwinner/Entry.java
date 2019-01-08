package com.codingwithmitch.patreonwinner;

public class Entry {

    String name;
    int donationAmount;

    public Entry(String name, int donationAmount) {
        this.name = name;
        this.donationAmount = donationAmount;
    }


    public Entry() {
    }

    public int getNumEntries(){
        return donationAmount / 5;
    }

    public int getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




