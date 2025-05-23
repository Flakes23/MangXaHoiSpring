package com.nhom6.mxh.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private LocalDateTime createAt;
    private Boolean isActive;
}