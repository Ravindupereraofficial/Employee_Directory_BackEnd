package edu.icet.ecom.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name can only contain Letters")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Email must follow a valid format (e.g., employee@company.com)"
    )
    private String email;

    @NotBlank(message = "Department is required")
    @Pattern(
            regexp = "^(HR|IT|Finance|Operations)$",
            message = "Department should one of the following: HR, IT, Finance, Operations"
    )
    private String department;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
