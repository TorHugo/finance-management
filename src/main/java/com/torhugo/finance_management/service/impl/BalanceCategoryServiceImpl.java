package com.torhugo.finance_management.service.impl;

import com.torhugo.finance_management.exception.impl.DataBaseException;
import com.torhugo.finance_management.mapper.BalanceCategoryMapper;
import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.dto.MonitoringBalanceDTO;
import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import com.torhugo.finance_management.model.enums.TypeBalance;
import com.torhugo.finance_management.repository.BalanceCategoryRepository;
import com.torhugo.finance_management.repository.BalanceRepository;
import com.torhugo.finance_management.repository.UserRepository;
import com.torhugo.finance_management.service.BalanceCategoryService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@Slf4j
public class BalanceCategoryServiceImpl implements BalanceCategoryService {

    @Autowired
    private BalanceCategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private BalanceCategoryMapper categoryMapper;

    @Override
    public BalanceCategoryDTO savedCategory(BalanceCategoryDTO balanceCategoryDTO){
        log.info("1. Validation existing user in the database.");
        if (!isUserExisting(balanceCategoryDTO.getIdUser()))
            throw new DataBaseException("User not found.");

        log.info("2. Mapping the category.");
        BalanceCategoryModel categoryModel = categoryMapper.mapper(balanceCategoryDTO);

        log.info("3. Saving category in database.");
        categoryRepository.save(categoryModel);

        return new BalanceCategoryDTO(categoryModel);
    }

    @Override
    public MonitoringBalanceDTO findAllMovimentsForCategory(Long idUser, Long idCategory) {
        BigDecimal amountSpent = BigDecimal.ZERO;
        
        log.info("1. Validation existing user in the database.");
        if (!isUserExisting(idUser))
            throw new DataBaseException("User not found.");

        log.info("2. Searching category in the database.");
        BalanceCategoryModel recuperedCategory =
                categoryRepository.findById(idCategory).orElseThrow(() -> new DataBaseException("Category not found."));

        log.info("3. Searching list of balance in the database.");
        List<BalanceModel> recuperedLsBalance =
                balanceRepository.findAllByIdCategory(idCategory);

        log.info("3-1. Adding values.");
        for(BalanceModel balance: recuperedLsBalance) {
            if (balance.getTypeBalance().equals(TypeBalance.PAYOUT))
                amountSpent = amountSpent.add(balance.getBalanceValue());
        }

        log.info("4. Mapping entity.");
        return categoryMapper.mapper(recuperedCategory, recuperedLsBalance, amountSpent);
    }

    private boolean isUserExisting(Long idUser){
        return userRepository.existsById(idUser);
    }
}
