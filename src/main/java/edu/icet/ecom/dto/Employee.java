package edu.icet.ecom.dto;

import edu.icet.ecom.util.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
