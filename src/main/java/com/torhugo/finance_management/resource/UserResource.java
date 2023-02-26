package com.torhugo.finance_management.resource;

import com.torhugo.finance_management.model.dto.UserDTO;
import com.torhugo.finance_management.service.UserService;
import com.torhugo.finance_management.util.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService service;

    @Autowired
    private ApplicationResponse response;

    @PostMapping
    public ResponseEntity<UserDTO> createdUser(
            @RequestBody final UserDTO userDTO){
        final UserDTO user = service.savedUser(userDTO);
        return ResponseEntity.status(response.created).body(user);
    }
}
