package edu.icet.ecom.service.EmployeeServiceimpl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.repository.EmployeeRepository;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }
}
