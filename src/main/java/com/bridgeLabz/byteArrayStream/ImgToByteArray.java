package com.bridgeLabz.byteArrayStream;

import java.io.*;

public class ImgToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/com/bridgeLabz/byteArrayStream/input.png";
        String outputImagePath = "output.png";

        try {
            // Convert image to byte array
            byte[] imageData = imageToByteArray(inputImagePath);
            System.out.println("Image successfully converted to byte array.");

            // Write byte array back to image file
            byteArrayToImage(imageData, outputImagePath);
            System.out.println("Image successfully written to " + outputImagePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to convert image to byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(imagePath);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    // Method to write byte array back to image
    public static void byteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
