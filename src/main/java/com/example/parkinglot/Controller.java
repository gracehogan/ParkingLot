package com.example.parkinglot;

public class Controller {

    private ParkingLotView view;
    private IParkingLot parkingLot;
    private Ticket ticket;

    public Controller(ParkingLotView view, Ticket ticket, IParkingLot parkingLot) {
        this.view = view;
        this.ticket = ticket;
        this.parkingLot = parkingLot;

        createCalculateButton();
    }

    private void createCalculateButton() {

        view.getCalculateButton().setOnAction(e -> {
            parkingLot = ParkingLotFactory.createParkingLot(view.getButtonSelection());
            String entryTimeString = view.getEntryTime().trim();
            String exitTimeString = view.getExitTime().trim();
            int durationDays = ticket.calculateDurationDays(entryTimeString, exitTimeString);
            int durationHours = ticket.calculateDurationHours(entryTimeString, exitTimeString);
            int durationMinutes = ticket.calculateDurationMinutes(entryTimeString, exitTimeString);
            int charge = parkingLot.calculateCharge(durationDays, durationHours, durationMinutes);
            view.displayCharge("Your total cost is $" + charge + ".\nHave a nice day!");
        });
    }


}
