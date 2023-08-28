package com.example.springc0423i1.service.user.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class UserSaveRequest {

    @Size(min = 6, max = 12, message = "Username must have 6-12 characters")
    @Pattern(regexp = "^[a-zA-Z1-9]",  message = "Username must not contain special characters ")
    private String username;

    @Email(message = "Invalid format Email")
    private String email;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dob;

    @NotBlank
    private String gender;

    private String fullName;

}
