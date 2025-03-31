package com.bridgeLabz.bufferedStream;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Harma\\bridgeLabz-workspace\\Java-Streams\\src\\main\\java\\com\\bridgeLabz\\bufferedStream\\Sample.mp4";   // Replace with your file path
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        System.out.println("Starting file copy...");

        // Measure time taken for Buffered Streams
        long startBuffered = System.nanoTime();
        copyWithBufferedStreams(sourceFile, destBuffered);
        long endBuffered = System.nanoTime();
        long timeBuffered = (endBuffered - startBuffered) / 1_000_000;

        // Measure time taken for Unbuffered Streams
        long startUnbuffered = System.nanoTime();
        copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        long endUnbuffered = System.nanoTime();
        long timeUnbuffered = (endUnbuffered - startUnbuffered) / 1_000_000;

        // Print performance comparison
        System.out.println("Time taken using Buffered Streams: " + timeBuffered + " ms");
        System.out.println("Time taken using Unbuffered Streams: " + timeUnbuffered + " ms");

        System.out.println("Buffered Streams are faster due to reduced I/O calls!");
    }

    //  Efficient Copy Using Buffered Streams
    public static void copyWithBufferedStreams(String src, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void copyWithUnbufferedStreams(String src, String dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData); // Writing one byte at a time (inefficient)
            }
            System.out.println("Unbuffered file copy completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
//Starting file copy...
//Buffered file copy completed.
//Unbuffered file copy completed.
//Time taken using Buffered Streams: 30 ms
//Time taken using Unbuffered Streams: 54772 ms
//Buffered Streams are faster due to reduced I/O calls!

