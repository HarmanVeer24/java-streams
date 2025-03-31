package com.bridgeLabz.BufferReaderFileWriter;

import java.io.*;

public class UpdateUserDetails {
    public static void main(String[] args) {
        // File where user data will be saved
        String fileName = "C:\\Users\\Harma\\bridgeLabz-workspace\\Java-Streams\\src\\main\\java\\com\\bridgeLabz\\BufferReaderFileWriter\\User_data.txt";

        // Using BufferedReader to take user input
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) { // Append mode

            // Asking for user details
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing user input to the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("Information saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
//Enter your name: Harman Veer Singh
//Enter your age: 21
//Enter your favorite programming language: java
//Information saved successfully in C:\Users\Harma\bridgeLabz-workspace\Java-Streams\src\main\java\com\bridgeLabz\BufferReaderFileWriter\User_data.txt
//output file
// Hello
// Name: Harman Veer Singh
//Age: 21
//Favorite Language: java