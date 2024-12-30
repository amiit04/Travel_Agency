package com.travelagency.travelagency.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private Long clientId;
    private String password;
    private  String role;

    public LoginDTO(Long clientId, String password, String role) {
        this.clientId = clientId;
        this.password = password;
        this.role = role;
    }
    public LoginDTO() {
    }
}
