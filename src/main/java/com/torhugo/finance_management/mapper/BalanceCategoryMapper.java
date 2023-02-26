package com.torhugo.finance_management.mapper;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import org.springframework.stereotype.Component;

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
}
