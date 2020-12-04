package com.company.businessrulesengine.spel;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class TextUtils {

    public boolean estaPreenchido(String value){
        return isNotBlank(value);
    }
}