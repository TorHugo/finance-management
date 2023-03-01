package com.torhugo.finance_management.service;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.dto.MonitoringBalanceDTO;

public interface BalanceCategoryService {
    public BalanceCategoryDTO savedCategory(BalanceCategoryDTO balanceCategoryDTO);
    public MonitoringBalanceDTO findAllMovimentsForCategory(Long idUser, Long idCategory);
}
