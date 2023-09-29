package com.example.parkinglot;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ParkingLotView {
    private Label welcomeLabel;
    private Label entryLabel;
    private TilePane r1;
    private DatePicker d1;
    private ComboBox hourEntry;
    private ComboBox minutesEntry;
    private Label exitLabel;
    private TilePane r2;
    private DatePicker d2;
    private ComboBox hourExit;
    private ComboBox minutesExit;
    private Label lotSelectionLabel;
    private RadioButton defaultLot;
    private RadioButton longStayLot;
    private RadioButton nearbyLot;
    private RadioButton shortStayLot;
    private Button calculateButton;
    private Label chargeLabel;

    private IParkingLot parkingLot;

    public ParkingLotView(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;

        initialiseUIComponents();
    }

    private void initialiseUIComponents() {
        welcomeLabel = new Label("Please enter your details below");
        welcomeLabel.setFont(new Font("Arial", 15));
        entryLabel = new Label("Entry date/time");
        entryLabel.setFont(new Font("Arial", 15));
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

        exitLabel = new Label("Exit date/time");
        exitLabel.setFont(new Font("Arial", 15));
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
        lotSelectionLabel.setFont(new Font("Arial", 15));
        defaultLot = new RadioButton("Normal");
        defaultLot.setFont(new Font("Arial", 15));
        longStayLot = new RadioButton("Long Stay");
        longStayLot.setFont(new Font("Arial", 15));
        nearbyLot = new RadioButton("Nearby Parking");
        nearbyLot.setFont(new Font("Arial", 15));
        shortStayLot = new RadioButton("ShortStay");
        shortStayLot.setFont(new Font("Arial", 15));

        defaultLot.setSelected(true);

        ToggleGroup tg = new ToggleGroup();
        defaultLot.setToggleGroup(tg);
        longStayLot.setToggleGroup(tg);
        nearbyLot.setToggleGroup(tg);
        shortStayLot.setToggleGroup(tg);
        calculateButton = new Button("Calculate cost");
        chargeLabel = new Label();
    }

    void initialiseLayout(Stage stage) {

        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox(10, welcomeLabel);
        VBox vBox1 = new VBox(10, entryLabel, r1, d1, hourEntry, minutesEntry);
        vBox.setAlignment(Pos.CENTER);
        VBox vBox2 = new VBox(10, exitLabel, r2, d2, hourExit, minutesExit);
        VBox vBox3 = new VBox(10, lotSelectionLabel, defaultLot, longStayLot, nearbyLot, shortStayLot,
                calculateButton, chargeLabel);

        vBox.setAlignment(Pos.CENTER);
        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox3.setAlignment(Pos.CENTER);
        borderPane.setTop(vBox);
        borderPane.setLeft(vBox1);
        borderPane.setRight(vBox2);
        borderPane.setBottom(vBox3);


        borderPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(0), Insets.EMPTY)));
        Scene scene = new Scene(borderPane, 500, 500);

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

    public LotType getButtonSelection() {

        if (defaultLot.isSelected()){
            return LotType.DEFAULTPARKING;
        }
        if (longStayLot.isSelected()) {
            return  LotType.LONGTERMPARKING;
        }
        if (nearbyLot.isSelected()) {
            return LotType.NEARBYPARKING;
        }
        if (shortStayLot.isSelected()) {
            return LotType.SHORTSTAYPARKING;
        }
        else return null;
    }
}
