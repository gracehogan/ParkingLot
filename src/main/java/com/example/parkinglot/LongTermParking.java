package com.example.parkinglot;

public class LongTermParking implements IParkingLot{
    @Override
    public int calculateCharge(int days, int hours, int minutes) {
        int hourlyRate = 4;

        int dailyRate = 20;

        int totalCharge = 0;

        if (days == 0 && hours < 4 && minutes < 0) {
            return totalCharge;
            //First 4 hours free
        } else {
            totalCharge += days * dailyRate;

            if (hours > 5 || (hours == 5 && minutes>0)) {
                totalCharge += dailyRate;
                //Over 5 hours = full day charge
            }

            else {
                totalCharge += hours * hourlyRate;

                if (minutes > 0) {
                    totalCharge += hourlyRate;
                }
                //Round up to hour
            }

            return totalCharge;
        }
    }
}
