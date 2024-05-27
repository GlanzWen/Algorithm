package com.glanz.java.bit;

public class BinarySummation {

    public static void main(String[] args) {

    }

    //不予置评
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}
