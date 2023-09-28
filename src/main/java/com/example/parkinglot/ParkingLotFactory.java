package com.example.parkinglot;

public class ParkingLotFactory {

    public IParkingLot createParkingLot(String parkingLotSelection) {


        if (parkingLotSelection == null || parkingLotSelection.isEmpty())
            return null;

        switch (parkingLotSelection) {
            case "ParkingLot":
                return new ParkingLot();

            case "LongTermParking":
                return new LongTermParking();

            case "NearbyParking":
                return new NearbyParking();

            case "ShortStayParking":
                return new ShortStayParking();

            default:
                throw new IllegalArgumentException("Unknown parking lot.");


        }

    }

}
