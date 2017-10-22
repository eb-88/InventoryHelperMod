package com.ebapps.inventoryhelper;
public class Helper
{
    public static float GetAsFloat(int Value) {
        return Float.parseFloat(String.valueOf(Value));
    }

    public static float GetAsFloat(String Value) {
        return Float.parseFloat(Value);
    }

    
}