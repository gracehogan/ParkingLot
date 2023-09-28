package com.example.parkinglot;

public class NearbyParking implements IParkingLot{
    @Override
    public int calculateCharge(int days, int hours, int minutes) {
        int hourlyRate = 1;

        int dailyRate = 10;

        int totalCharge = 0;

        if (days == 0 && hours == 0 && minutes < 15) {
            return totalCharge;
            //First 15 mins free
        } else {
            totalCharge += days * dailyRate;

            if (hours > 10 || (hours == 10 && minutes>0)) {
                totalCharge += dailyRate;
                //Over 10 hours = full day charge
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
