package com.bridgeLabz.BufferedReaderBufferedWriter;

import java.io.*;

public class ConvertUpperToLower {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/bridgeLabz/BufferedReaderBufferedWriter/inputdata.txt";
        String outputFile = "output.txt";

        convertToLowerCase(inputFile, outputFile);
    }

    public static void convertToLowerCase(String inputFile, String outputFile) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // Preserve line breaks
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}

