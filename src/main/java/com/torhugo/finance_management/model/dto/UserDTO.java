package com.torhugo.finance_management.model.dto;

import com.torhugo.finance_management.model.entity.UserModel;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Long idUser;
    @NotBlank(message = "Requeired field!")
    private String name;
    @NotBlank(message = "Requeired field!")
    private String email;
    @NotBlank(message = "Requeired field!")
    private String password;


    public UserDTO(UserModel userModel) {
        this.idUser = userModel.getIdUser();
        this.name = userModel.getName();
        this.email = userModel.getEmail();
        this.password = userModel.getPassword();
    }
}