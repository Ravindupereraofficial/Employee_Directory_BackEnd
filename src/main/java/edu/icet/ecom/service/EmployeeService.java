package edu.icet.ecom.service;

import edu.icet.ecom.dto.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);

}

