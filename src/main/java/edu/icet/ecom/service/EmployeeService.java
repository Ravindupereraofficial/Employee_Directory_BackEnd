package edu.icet.ecom.service;

import edu.icet.ecom.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(Long id);

    void deleteById(Long id);

    Employee update(Long id,Employee employee);

    List<Employee> findall();
}
