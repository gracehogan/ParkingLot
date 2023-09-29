package com.example.parkinglot;

public class ParkingLotFactory {

    public static IParkingLot createParkingLot(LotType lotType) {

        if (lotType == null)
            return null;

        switch (lotType) {
            case DEFAULTPARKING:
                return new ParkingLot();

            case LONGTERMPARKING:
                return new LongTermParking();

            case NEARBYPARKING:
                return new NearbyParking();

            case SHORTSTAYPARKING:
                return new ShortStayParking();

            default:
                throw new IllegalArgumentException("Unknown parking lot.");

        }

    }

}
