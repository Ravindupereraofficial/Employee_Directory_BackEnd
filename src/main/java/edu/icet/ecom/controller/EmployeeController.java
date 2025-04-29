package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Employee;
import edu.icet.ecom.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
@CrossOrigin()
public class EmployeeController {

    private final EmployeeService service;


    @PostMapping("/add")
    public ResponseEntity<Employee> add(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = service.save(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {
        Employee updatedEmployee = service.update(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Employee> searchEmployeeById(@PathVariable Long id) {
        Employee employee = service.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.findall();
        return ResponseEntity.ok(employees);
    }

}
