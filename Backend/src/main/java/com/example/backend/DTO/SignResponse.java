package com.example.backend.DTO;

import com.example.backend.Entity.Authority;
import com.example.backend.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private Long id;

    private String name;

    private String email;

    private List<Authority> roles = new ArrayList<>();

    private String token;

    private Boolean Activated;

    public SignResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.roles = member.getRoles();
        this.Activated = member.getActivated();
    }
}