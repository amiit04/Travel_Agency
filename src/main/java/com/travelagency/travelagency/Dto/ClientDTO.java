package com.travelagency.travelagency.Dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClientDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private String password;
    private String identityType;
    private String identityNumber;
    private String nationality;

    public ClientDTO(){
    }

    public ClientDTO(String name, String email, String phone, String address, Date dob, String identityType, String identityNumber, String nationality, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.password = password;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.nationality = nationality;
    }
}
