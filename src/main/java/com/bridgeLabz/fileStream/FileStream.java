package com.bridgeLabz.fileStream;

import java.io.*;

public class FileStream {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Harma\\bridgeLabz-workspace\\Java-Streams\\src\\main\\java\\com\\bridgeLabz\\fileStream\\Source.txt";   // Source file to read from
        String destinationFile = "C:\\Users\\Harma\\bridgeLabz-workspace\\Java-Streams\\src\\main\\java\\com\\bridgeLabz\\fileStream\\DestinationFile.txt"; // Destination file to write to

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            File inputFile = new File(sourceFile);

            // Check if the source file exists
            if (!inputFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            // Open file streams
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteData); // Writing byte-by-byte to destination
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                // Close the file streams to free resources
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file streams: " + e.getMessage());
            }
        }
    }
}
