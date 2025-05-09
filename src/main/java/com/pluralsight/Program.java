package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read inventory.txt");
            e.printStackTrace();
        }
    }
}
