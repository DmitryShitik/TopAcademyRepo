package ru.DimaShitik.Service;

import ru.DimaShitik.Models.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    String pathToEmployeeFile = "src/main/java/ru/DimaShitik/Resourse/Employee.txt";
    String pathToTempFile = "src/main/java/ru/DimaShitik/Resourse/TempFile.txt";
    private byte idFullName = 1;
    private byte id = 0;
    private byte idDepartment = 6;
    private byte idSupervisor = 7;

    @Override
    public void addNewEmployee(Employee employee) {
        if (isExist(employee)) {
            System.out.println("Employee is exist");
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToEmployeeFile, true))) {
                bw.write(employee.toString());
            } catch (IOException ex) {
                System.out.println(ex.fillInStackTrace());
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (isExist(employee)) {
            try (BufferedReader br = createReader(pathToEmployeeFile);
                 BufferedWriter bwTemp = createWriter(pathToTempFile)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (compareFindElement(parts[idFullName], employee)) {
                        continue;
                    }
                    bwTemp.write(line + "\n");
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.fillInStackTrace());
            } catch (IOException ex) {
                System.out.println(ex.fillInStackTrace());
            }
            writeFromTempInEmployeeFiles();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String[] beforeUpdate = employee.toString().split(";");
        try (BufferedReader br = createReader(pathToEmployeeFile);
             BufferedWriter bwTemp = createWriter(pathToTempFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (compareFindElement(parts[idFullName], employee)) {
                    beforeUpdate[id] = parts[id];
                    line = String.join("; ", beforeUpdate);
                }
                bwTemp.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writeFromTempInEmployeeFiles();
    }

    @Override
    public String getEmployee(String fullName) {
        String FoundEmployee = "";
        try (BufferedReader br = createReader(pathToEmployeeFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (!compareFindElement(parts[idFullName], fullName)) {
                    continue;
                }
                FoundEmployee = String.join("; ", parts);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return FoundEmployee;
    }

    @Override
    public List getAllEmployees() {
        List<String> allEmployee = new ArrayList<>();
        try (BufferedReader br = createReader(pathToEmployeeFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                allEmployee.add(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allEmployee;
    }

    @Override
    public List getAllByDepartment(String department) {
        List<String> employeeByDepartment = new ArrayList<>();
        try (BufferedReader br = createReader(pathToEmployeeFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (!compareFindElement(parts[idDepartment], department)) {
                    continue;
                }
                employeeByDepartment.add(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeByDepartment;
    }

    @Override
    public List getAllBySupervisor(String supervisor) {
        List<String> employeeByDepartment = new ArrayList<>();
        try (BufferedReader br = createReader(pathToEmployeeFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (!compareFindElement(parts[idSupervisor], supervisor)) {
                    continue;
                }
                employeeByDepartment.add(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeByDepartment;
    }

    @Override
    public boolean isExist(Employee employee) {
        try (BufferedReader br = createReader(pathToEmployeeFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (compareFindElement(parts[idFullName], employee)) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.fillInStackTrace());
        } catch (IOException ex) {
            System.out.println(ex.fillInStackTrace());
        }
        return false;
    }

    private boolean compareFindElement(String fullNameFromFile, Employee employee) {
        return fullNameFromFile.trim().equals(employee.getFullName());
    }

    private boolean compareFindElement(String fullNameFromFile, String findElement) {
        return fullNameFromFile.trim().equals(findElement);
    }

    private BufferedReader createReader(String filePath) throws IOException {
        return Files.newBufferedReader(Paths.get(filePath));
    }

    private BufferedWriter createWriter(String filePath) throws IOException {
        return Files.newBufferedWriter(Paths.get(filePath));
    }

    private void writeFromTempInEmployeeFiles() {
        try (BufferedReader brTemp = createReader(pathToTempFile);
             BufferedWriter bw = createWriter(pathToEmployeeFile)) {
            String line;
            while ((line = brTemp.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.fillInStackTrace());
        } catch (IOException ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }
}
