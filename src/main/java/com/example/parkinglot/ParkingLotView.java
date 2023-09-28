package com.example.parkinglot;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

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

    private TilePane r1;

    private DatePicker d1;

    private ComboBox hourEntry;

    private ComboBox minutesEntry;
    private TilePane r2;

    private DatePicker d2;

    private ComboBox hourExit;

    private ComboBox minutesExit;

    public ParkingLotView(IParkingLot parkingLot, IParkingLot longTermLot, IParkingLot nearbyParkingLot, IParkingLot shortTermLot) {
        this.parkingLot = parkingLot;
        this.longTermLot = longTermLot;
        this.nearbyParkingLot = nearbyParkingLot;
        this.shortTermLot = shortTermLot;

        initialiseUIComponents();
    }

    private void initialiseUIComponents() {
        entryLabel = new Label("Please enter your date and time of entry");
        r1 = new TilePane();
        d1 = new DatePicker();
        hourEntry = new ComboBox<>();
        minutesEntry = new ComboBox<>();
        hourEntry.getItems().addAll("Hours", "00", "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12",
                "13", "14", "15", "16",
                "17", "18", "19", "20",
                "21", "22", "23", "24");
        minutesEntry.getItems().addAll("Minutes", "00", "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12",
                "13", "14", "15", "16",
                "17", "18", "19", "20",
                "21", "22", "23", "24",
                "25", "26", "27", "28",
                "29", "30", "31", "32",
                "33", "34", "35", "36",
                "37", "38", "39", "40",
                "41", "42", "43", "44",
                "45", "46", "47", "48",
                "49", "50", "51", "52",
                "53", "54", "55", "56",
                "57", "58", "59", "60");


        //entryTime = new TextField("dd-MM-yyyy HH:mm");
        exitLabel = new Label("Please enter your date and time of exit");
        //exitTime = new TextField("dd-MM-yyyy HH:mm");
        r2 = new TilePane();
        d2 = new DatePicker();
        hourExit = new ComboBox<>();
        minutesExit = new ComboBox<>();
        hourExit.getItems().addAll("Hours", "00", "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12",
                "13", "14", "15", "16",
                "17", "18", "19", "20",
                "21", "22", "23", "24");
        minutesExit.getItems().addAll("Minutes", "00", "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12",
                "13", "14", "15", "16",
                "17", "18", "19", "20",
                "21", "22", "23", "24",
                "25", "26", "27", "28",
                "29", "30", "31", "32",
                "33", "34", "35", "36",
                "37", "38", "39", "40",
                "41", "42", "43", "44",
                "45", "46", "47", "48",
                "49", "50", "51", "52",
                "53", "54", "55", "56",
                "57", "58", "59", "60");
        lotSelectionLabel = new Label("Please select your parking lot");
        defaultLot = new RadioButton("Normal");
        longStayLot = new RadioButton("Long Stay");
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
        VBox vBox = new VBox(10, entryLabel, r1, d1, hourEntry, minutesEntry, exitLabel, r2, d2, hourExit, minutesExit,
                lotSelectionLabel, defaultLot, longStayLot, nearbyLot, shortStayLot,
                calculateButton, chargeLabel);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 500, 500);


        //Staging
        stage.setTitle("Parking Lot Cost Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public Button getCalculateButton() {
        return calculateButton;
    }

    public String getEntryTime() {
        String timeEntry = d1.getValue().toString() + hourEntry.getValue().toString() + minutesEntry.getValue().toString();

        return timeEntry;
    }

    public String getExitTime() {
        String timeExit = (d2.getValue().toString() + hourExit.getValue().toString() + minutesExit.getValue().toString());

        return timeExit;
    }

    public void displayCharge(String message) {
        chargeLabel.setText(message);

    }

    public IParkingLot getButtonSelection() {

        if (longStayLot.isSelected()) {
            return longTermLot;
        }
        if (nearbyLot.isSelected()) {
            return nearbyParkingLot;
        }
        if (shortStayLot.isSelected()) {
            return shortTermLot;
        }
        else
                return parkingLot;


    }
}
