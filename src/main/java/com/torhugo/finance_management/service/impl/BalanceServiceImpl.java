package com.torhugo.finance_management.service.impl;

import com.torhugo.finance_management.exception.impl.DataBaseException;
import com.torhugo.finance_management.mapper.BalanceMapper;
import com.torhugo.finance_management.model.dto.BalanceDTO;
import com.torhugo.finance_management.model.dto.LsBalanceDTO;
import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import com.torhugo.finance_management.model.entity.UserModel;
import com.torhugo.finance_management.repository.BalanceCategoryRepository;
import com.torhugo.finance_management.repository.BalanceRepository;
import com.torhugo.finance_management.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private BalanceCategoryRepository categoryRepository;

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public List<BalanceDTO> savedLsBalance(LsBalanceDTO lsBalanceDTO) {
        lsBalanceDTO.getLsBalance().forEach(balance -> {
            log.info("1. Validating exists user wallet in the database.");
            BalanceCategoryModel categoryModel =
                    categoryRepository.findById(balance.getIdCategory()).orElseThrow(() -> new DataBaseException("Entity not found!"));

            log.info("2. Mapping the balance.");
            BalanceModel model = balanceMapper.mapper(balance);

            log.info("3. Saving balance in database.");
            balanceRepository.save(model);
        });

        return lsBalanceDTO.getLsBalance().stream().map(BalanceDTO::new).collect(Collectors.toList());
    }
}
