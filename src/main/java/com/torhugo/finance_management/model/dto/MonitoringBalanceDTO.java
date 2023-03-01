package com.torhugo.finance_management.model.dto;

import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MonitoringBalanceDTO {
    private String nameCategory;
    private String descriptionCategory;
    private BigDecimal budget;
    private BigDecimal amountSpent;
    private List<BalanceModel> lsBalance;

    public MonitoringBalanceDTO(BalanceCategoryModel categoryModel, List<BalanceModel> lsBalance){
        this.nameCategory = categoryModel.getNameCategory();
        this.descriptionCategory = categoryModel.getDescriptionCategory();
        this.budget = categoryModel.getBudget();
        this.amountSpent = categoryModel.getAmountSpent();
        this.lsBalance = lsBalance;
    }
}
