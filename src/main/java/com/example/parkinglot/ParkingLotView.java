package com.example.parkinglot;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParkingLotView {
    private Label entryLabel;
    private TextField entryTime;
    private Label exitLabel;
    private TextField exitTime;

    private Label lotSelectionLabel;
    private RadioButton defaultLot;

    private RadioButton longStayLot;

    private RadioButton nearbyLot;

    private RadioButton shortStayLot;
    private Button calculateButton;
    private Label chargeLabel;


    private IParkingLot parkingLot;
    private IParkingLot longTermLot;
    private IParkingLot nearbyParkingLot;
    private IParkingLot shortTermLot;


    public ParkingLotView(IParkingLot parkingLot, IParkingLot longTermLot, IParkingLot nearbyParkingLot, IParkingLot shortTermLot) {
        this.parkingLot = parkingLot;
        this.longTermLot = longTermLot;
        this.nearbyParkingLot = nearbyParkingLot;
        this.shortTermLot = shortTermLot;

        initialiseUIComponents();
    }

    private void initialiseUIComponents() {
        entryLabel = new Label("Please enter your date and time of entry");
        entryTime = new TextField("dd-MM-yyyy HH:mm");
        exitLabel = new Label("Please enter your date and time of exit");
        exitTime = new TextField("dd-MM-yyyy HH:mm");
        lotSelectionLabel = new Label("Please select your parking lot");
        defaultLot = new RadioButton("Normal");
        longStayLot= new RadioButton("Long Stay");
        nearbyLot = new RadioButton("Nearby Parking");
        shortStayLot = new RadioButton("ShortStay");

        defaultLot.setSelected(true);

        ToggleGroup tg = new ToggleGroup();
        defaultLot.setToggleGroup(tg);
        longStayLot.setToggleGroup(tg);
        nearbyLot.setToggleGroup(tg);
        shortStayLot.setToggleGroup(tg);
        calculateButton = new Button("Calculate cost");
        chargeLabel = new Label();

        RadioButton selectedRadioButton =
                (RadioButton) tg.getSelectedToggle();


    }

    void initialiseLayout(Stage stage) {
        VBox vBox = new VBox(10, entryLabel, entryTime, exitLabel, exitTime,
                lotSelectionLabel, defaultLot, longStayLot, nearbyLot, shortStayLot,
                calculateButton, chargeLabel);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 400);

        //Staging
        stage.setTitle("Parking Lot Cost Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public Button getCalculateButton() {
        return calculateButton;
    }

    public String getEntryTime() {
        return entryTime.getText();
    }

    public String getExitTime() {
        return exitTime.getText();
    }

    public void displayCharge(String message) {
        chargeLabel.setText(message);

    }
}
