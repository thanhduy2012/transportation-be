package com.ptit.transportationmanagement.common.utils;

public class StringUtils {

    public static Boolean isEmpty(String str){
        if(str == null) return true;
        if(str.isEmpty()) return true;
        return false;
    }
}
