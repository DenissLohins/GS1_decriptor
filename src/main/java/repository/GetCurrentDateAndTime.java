package repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDateAndTime {


    String getDate(){
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        LocalDate now = LocalDate.now();
        return dateFormater.format(now);
    }

    String getTime(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();
        return timeFormatter.format(now);
    }
}

