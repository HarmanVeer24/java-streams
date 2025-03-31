package com.bridgeLabz.dataInputoutputStream;

import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDetails{
    private static final String FILE_NAME = "students.dat";

    public static void writeStudentsToFile(Student[] students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Student student : students) {
                dos.writeInt(student.rollNumber);
                dos.writeUTF(student.name);
                dos.writeDouble(student.gpa);
            }
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readStudentsFromFile() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data from file:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(101, "Harman", 9.8),
                new Student(102, "Aaryan", 9.5),
                new Student(103, "Mohit", 9.9)
        };

        writeStudentsToFile(students);
        readStudentsFromFile();
    }
}
