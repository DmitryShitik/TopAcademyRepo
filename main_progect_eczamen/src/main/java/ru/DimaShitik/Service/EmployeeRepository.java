package ru.DimaShitik.Service;

import ru.DimaShitik.Models.Employee;

import java.util.List;

public interface EmployeeRepository {
    void addNewEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(Employee employee);
    String getEmployee(String fullName);
    List getAllEmployees();
    List getAllByDepartment(String department);
    List getAllBySupervisor(String supervisor);
    boolean isExist(Employee employee);
}
