package com.ivpion.utils;

public class LazyDate {

    public static int getUnixTimestamp(){
        return (int) (System.currentTimeMillis() / 1000);
    }
}
