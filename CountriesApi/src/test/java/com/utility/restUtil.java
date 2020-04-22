package com.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class restUtil {
    public static String  resultNumber(){
        String generateNumber = RandomStringUtils.randomNumeric(3);
        return ("number = "+generateNumber);
    }
}
