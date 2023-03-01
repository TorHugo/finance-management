package com.torhugo.finance_management.mapper;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.dto.BalanceDTO;
import com.torhugo.finance_management.model.dto.MonitoringBalanceDTO;
import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BalanceCategoryMapper {

    public BalanceCategoryModel mapper (BalanceCategoryDTO balanceCategoryDTO){
        BalanceCategoryModel categoryModel = new BalanceCategoryModel();
        categoryModel.setIdCategory(balanceCategoryDTO.getIdCategory());
        categoryModel.setIdUser(balanceCategoryDTO.getIdUser());
        categoryModel.setNameCategory(balanceCategoryDTO.getNameCategory());
        categoryModel.setDescriptionCategory(balanceCategoryDTO.getDescriptionCategory());
        categoryModel.setBudget(balanceCategoryDTO.getBudget());

        categoryModel.setLsBalance(null);

        return categoryModel;
    }

    public MonitoringBalanceDTO mapper(BalanceCategoryModel recuperedCategory, List<BalanceModel> recuperedLsBalance, BigDecimal amountSpent) {
        MonitoringBalanceDTO monitoringBalanceDTO = new MonitoringBalanceDTO();
        monitoringBalanceDTO.setNameCategory(recuperedCategory.getNameCategory());
        monitoringBalanceDTO.setDescriptionCategory(recuperedCategory.getDescriptionCategory());
        monitoringBalanceDTO.setBudget(recuperedCategory.getBudget());
        monitoringBalanceDTO.setAmountSpent(amountSpent);
        monitoringBalanceDTO.setLsBalance(recuperedLsBalance);

        return monitoringBalanceDTO;
    }
}
