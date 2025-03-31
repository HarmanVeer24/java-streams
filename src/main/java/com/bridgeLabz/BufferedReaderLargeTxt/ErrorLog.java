package com.bridgeLabz.BufferedReaderLargeTxt;

import java.io.*;

public class ErrorLog {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/BufferedReaderLargeTxt/Sample.txt"; // Replace with your actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
