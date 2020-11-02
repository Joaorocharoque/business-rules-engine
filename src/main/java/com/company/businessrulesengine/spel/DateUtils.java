package com.company.businessrulesengine.spel;

import java.time.LocalDate;

public class DateUtils {

    public boolean isAfterNow(LocalDate localDate){
        return localDate.isAfter(LocalDate.now());
    }
}