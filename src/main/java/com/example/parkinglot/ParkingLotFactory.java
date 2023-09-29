package com.example.parkinglot;

public class ParkingLotFactory {

    public IParkingLot createParkingLot(String buttonSelection) {

        if (buttonSelection == null || buttonSelection.isEmpty())
            return null;

        switch (buttonSelection) {
            case "parkingLot":
                return new ParkingLot();

            case "longTermLot":
                return new LongTermParking();

            case "nearbyParkingLot":
                return new NearbyParking();

            case "shortTermLot":
                return new ShortStayParking();

            default:
                throw new IllegalArgumentException("Unknown parking lot.");

        }

    }

}
