package edu.icet.ecom.service.EmployeeServiceimpl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.entity.EmployeeEntity;
import edu.icet.ecom.repository.EmployeeRepository;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, Employee.class))
                .collect(Collectors.toList());
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        EmployeeEntity saved = repository.save(entity);
        return modelMapper.map(saved, Employee.class);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity existing = repository.findById(id).orElseThrow();
        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setUpdatedAt(LocalDateTime.now());
        EmployeeEntity updated = repository.save(existing);
        return modelMapper.map(updated, Employee.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .map(entity -> modelMapper.map(entity, Employee.class))
                .orElseThrow();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findAll().stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .map(entity -> modelMapper.map(entity, Employee.class))
                .collect(Collectors.toList());
    }
}
