package com.bridgeLabz.pipedStream;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            outputStream.write(message.getBytes());
            outputStream.close(); // Close stream after writing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;

    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String receivedMessage = reader.readLine();
            System.out.println("ReaderThread received: " + receivedMessage);
            inputStream.close(); // Close stream after reading
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

