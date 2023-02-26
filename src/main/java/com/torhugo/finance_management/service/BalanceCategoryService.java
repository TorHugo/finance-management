package com.torhugo.finance_management.service;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;

public interface BalanceCategoryService {
    public BalanceCategoryDTO savedCategory(BalanceCategoryDTO balanceCategoryDTO) throws Exception;
}
