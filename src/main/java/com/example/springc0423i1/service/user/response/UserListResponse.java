package com.example.springc0423i1.service.user.response;

import com.example.springc0423i1.domain.enumration.EGender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserListResponse {

    private Long id;

    private String username;

    private String email;

    private LocalDate dob;

    private EGender gender;

    private String fullName;
}
