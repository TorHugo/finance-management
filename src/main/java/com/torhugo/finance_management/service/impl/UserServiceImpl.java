package com.torhugo.finance_management.service.impl;

import com.torhugo.finance_management.mapper.UserMapper;
import com.torhugo.finance_management.model.dto.UserDTO;
import com.torhugo.finance_management.model.entity.UserModel;
import com.torhugo.finance_management.repository.UserRepository;
import com.torhugo.finance_management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO savedUser(UserDTO userDTO) {

        log.info("1. Mapping the user.");
        UserModel model = mapper.mapper(userDTO);

        log.info("2. Saving user in database.");
        userRepository.save(model);

        return new UserDTO(model);
    }
}
