package com.torhugo.finance_management.mapper;

import com.torhugo.finance_management.model.dto.UserDTO;
import com.torhugo.finance_management.model.entity.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel mapper (UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        userModel.setLsBalanceCategory(null);

        return userModel;
    }
}
