package ru.DimaShitik.Models;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Employee {
    String pathToEmployeeFile = "src/main/java/ru/DimaShitik/Resourse/Employee.txt";
    private int id;
    private static int counter = 0;
    private String fullName;
    private String dateOfBirth;
    private String sex;
    private String phoneNumber;
    private String post;
    private String department;
    private String supervisor;
    private String hireDate;
    private double salary;

    public Employee() {
        if(counter == 0){
            if (new File(pathToEmployeeFile).length() > 0){
                try {
                    String buffer = (Files.readAllLines(Paths.get(pathToEmployeeFile), StandardCharsets.UTF_8)
                            .get(Files.readAllLines(Paths.get(pathToEmployeeFile), StandardCharsets.UTF_8).size() - 1));
                    String[] parts = buffer.split(",");
                    counter = Integer.parseInt(parts[0]) + 1;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        id = counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return
                id + "; " + fullName + "; " + dateOfBirth + "; " + sex + "; " + phoneNumber + "; " +
                        post + "; " + department + "; " + supervisor + "; " + hireDate + "; " + salary + "\n";
    }
}
