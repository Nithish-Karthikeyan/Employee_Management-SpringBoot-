package com.ideas2it.dateTimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public String getDate() {
        String currentDateAndTime;
        String dateTimeFormatter = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateTimeFormatter);
        currentDateAndTime = currentDate.format(dateFormatter);
        return currentDateAndTime;
    }
}
