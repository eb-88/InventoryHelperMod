package com.ebapps.inventoryhelper;

import java.io.PrintWriter;

//import sun.applet.Main;
//import java.io.*;
//import java.io.PrintWriter;




public class Error
{
    public static void SaveErrorMessage(String ErrorMessage)
    {
        try {
            PrintWriter writer = new PrintWriter("C:\\temp\\javadebug.txt", "UTF-8");
            writer.println(ErrorMessage);
            writer.close();
        }
        catch(Exception ex) {
            System.out.println("FEHLER: " + ex.getMessage());
        }
    }
}