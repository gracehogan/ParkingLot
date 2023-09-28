package com.example.parkinglot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App extends Application {


    private IParkingLot parkingLot = new ParkingLot();
    private IParkingLot longTermLot = new LongTermParking();
    private IParkingLot nearbyParkingLot = new NearbyParking();
    private IParkingLot shortTermLot = new ShortStayParking();
    private ParkingLotView view;

    private Controller controller;

    private Ticket ticket = new Ticket();



    @Override
    public void start(Stage stage) throws IOException {

        view = new ParkingLotView(parkingLot, longTermLot, nearbyParkingLot, shortTermLot);

        view.initialiseLayout(stage);

        controller = new Controller(view, ticket, parkingLot, longTermLot,
                nearbyParkingLot, shortTermLot);

    }

    public static void main(String[] args) {
        launch();
    }
}