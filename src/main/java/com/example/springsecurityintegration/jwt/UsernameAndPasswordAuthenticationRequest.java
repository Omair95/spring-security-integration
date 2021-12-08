package com.example.springsecurityintegration.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;
}
