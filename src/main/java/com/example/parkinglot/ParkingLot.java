package com.example.parkinglot;

public class ParkingLot implements IParkingLot{

    public int calculateCharge(int days, int hours, int minutes) {
        int hourlyRate = 2;

        int dailyRate = 15;

        int totalCharge = 0;

        if (days == 0 && hours == 0 && minutes <= 30) {
            return totalCharge;

        } else {
            totalCharge += days*dailyRate;

            if (hours > 7 || (hours == 7 && minutes>0)) {
                totalCharge += dailyRate;
            }

            else {
                totalCharge += hours * hourlyRate;

                if (minutes > 0) {
                    totalCharge += hourlyRate;
                }
            }

            return totalCharge;
        }

    }
}
