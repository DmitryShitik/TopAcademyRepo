package ru.DimaShitik;

import ru.DimaShitik.Models.Employee;
import ru.DimaShitik.Service.EmployeeRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setFullName(String.valueOf(i));
            employeeRepository.addNewEmployee(employee);
        }
        EmployeeRepositoryImpl empimp = new EmployeeRepositoryImpl();
        System.out.println(empimp.getAllByDepartment("zxc"));

    }
    /*private static void createDesktopPath(){
        String desktopPath = createDesktopPathUsingSystemProperty();
        System.out.println("Desktop path: " + desktopPath);
    }

    private static String createDesktopPathUsingSystemProperty(){
        return System.getProperty("user.name") + "/Desktop/";
    }*/
}
