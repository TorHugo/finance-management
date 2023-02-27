package com.torhugo.finance_management.service.impl;

import com.torhugo.finance_management.exception.impl.DataBaseException;
import com.torhugo.finance_management.mapper.BalanceCategoryMapper;
import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.repository.BalanceCategoryRepository;
import com.torhugo.finance_management.repository.UserRepository;
import com.torhugo.finance_management.service.BalanceCategoryService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class BalanceCategoryServiceImpl implements BalanceCategoryService {

    @Autowired
    private BalanceCategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BalanceCategoryMapper categoryMapper;

    @Override
    public BalanceCategoryDTO savedCategory(BalanceCategoryDTO balanceCategoryDTO) throws Exception {
        log.info("1. Validation existing user in the database.");
        if (!validationExistingUser(balanceCategoryDTO.getIdUser()))
            throw new DataBaseException("User not found.");

        log.info("2. Mapping the category.");
        BalanceCategoryModel categoryModel = categoryMapper.mapper(balanceCategoryDTO);

        log.info("3. Saving category in database.");
        categoryRepository.save(categoryModel);

        return new BalanceCategoryDTO(categoryModel);
    }

    private boolean validationExistingUser(Long idUser){
        return userRepository.existsById(idUser);
    }
}
