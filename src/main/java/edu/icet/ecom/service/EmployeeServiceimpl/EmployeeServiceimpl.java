package edu.icet.ecom.service.EmployeeServiceimpl;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }
}
