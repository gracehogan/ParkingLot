package com.example.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    public int calculateDurationDays(String entry, String exit) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");

        String entryTimeTicket = entry;
        LocalDateTime dateAndTimeOne = LocalDateTime.parse(entryTimeTicket, formatter);

        String exitTimeTicket = exit;
        LocalDateTime dateAndTimeTwo = LocalDateTime.parse(exitTimeTicket, formatter);

        Duration duration = Duration.between(dateAndTimeOne, dateAndTimeTwo);

        return Math.toIntExact(duration.toDays());
    }
    public int calculateDurationHours(String entry, String exit) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");

        String entryTimeTicket = entry;
        LocalDateTime dateAndTimeOne = LocalDateTime.parse(entryTimeTicket, formatter);

        String exitTimeTicket = exit;
        LocalDateTime dateAndTimeTwo = LocalDateTime.parse(exitTimeTicket, formatter);

        Duration duration = Duration.between(dateAndTimeOne, dateAndTimeTwo);

        return duration.toHoursPart();
    }

    public int calculateDurationMinutes(String entry, String exit) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");

        String entryTimeTicket = entry;
        LocalDateTime dateAndTimeOne = LocalDateTime.parse(entryTimeTicket, formatter);

        String exitTimeTicket = exit;
        LocalDateTime dateAndTimeTwo = LocalDateTime.parse(exitTimeTicket, formatter);

        Duration duration = Duration.between(dateAndTimeOne, dateAndTimeTwo);

        return duration.toMinutesPart();
    }
}
