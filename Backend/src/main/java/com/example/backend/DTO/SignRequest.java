package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

    private String email;

    private String password;

    private String name;

}