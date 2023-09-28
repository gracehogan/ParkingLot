package com.example.parkinglot;

public class ShortStayParking implements IParkingLot {

    @Override
    public int calculateCharge(int days, int hours, int minutes) {
        int hourlyRate = 1;

        int dailyRate = 24;

        int totalCharge = 0;

        if (days == 0 && hours < 1 && minutes < 0) {
            return totalCharge;
            //First hour free
        } else {
            totalCharge += days * dailyRate;

            totalCharge += hours * hourlyRate;

            return totalCharge;
        }
    }
}

