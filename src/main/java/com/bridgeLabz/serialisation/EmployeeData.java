package com.bridgeLabz.serialisation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display Employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeData {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter employee details:");

        // Taking user input for employees
        for (int i = 1; i <= 2; i++) { // Collecting 2 employees for simplicity
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize the employee list
        serializeEmployees(employees);

        // Deserialize and display employee details
        List<Employee> retrievedEmployees = deserializeEmployees();
        System.out.println("Deserialized Employee List:");
        for (Employee emp : retrievedEmployees) {
            emp.display();
        }

        scanner.close();
    }

    // Method to serialize employee list
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println(" Employees saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Method to deserialize employee list
    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        }
        return employees;
    }
}
