package com.example.parkinglot;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private ParkingLotView view;

    private Controller controller;

    private Ticket ticket = new Ticket();
    IParkingLot parkingLot;
    @Override
    public void start(Stage stage) throws IOException {


        view = new ParkingLotView(parkingLot);

        view.initialiseLayout(stage);

        controller = new Controller(view, ticket, parkingLot);

    }

    public static void main(String[] args) {
        launch();
    }
}