package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.exceptionHandling.EmailAlreadyExistsException;
import edu.icet.ecom.exceptionHandling.ResourceNotFoundException;
import edu.icet.ecom.repository.EmployeeRepository;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;
    private final ModelMapper mapper;

    @Override
    public Employee save(Employee employee) {
        if (repo.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employee.getEmail());
        }
        EmployeeEntity save = repo.save(mapper.map(employee, EmployeeEntity.class));
        return mapper.map(save, Employee.class);
    }

    @Override
    public Employee findById(Long id) {
        return repo.findById(id)
                .map(entity -> mapper.map(entity, Employee.class))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public Employee update(Long id, Employee employeeData) {
        Employee employee = findById(id);

        if (!employee.getEmail().equals(employeeData.getEmail()) &&
                repo.existsByEmail(employeeData.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employeeData.getEmail());
        }

        employee.setName(employeeData.getName());
        employee.setEmail(employeeData.getEmail());
        employee.setDepartment(employeeData.getDepartment());

        EmployeeEntity save = repo.save(mapper.map(employee, EmployeeEntity.class));
        return mapper.map(save, Employee.class);
    }

    @Override
    public List<Employee> findall() {
        List<Employee> list = new ArrayList<>();
        List<EmployeeEntity> all = repo.findAll();
        all.forEach(employeeEntity -> list.add(mapper.map(employeeEntity, Employee.class)));
        return list;
    }
}


