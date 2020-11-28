package com.company.businessrulesengine.spel;

import java.time.LocalDate;

public class DateUtils {

    public boolean dataAposHoje(LocalDate localDate){
        return localDate.isAfter(LocalDate.now());
    }
}