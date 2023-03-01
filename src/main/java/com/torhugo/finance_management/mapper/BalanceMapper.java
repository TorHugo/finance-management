package com.torhugo.finance_management.mapper;

import com.torhugo.finance_management.model.dto.BalanceDTO;
import com.torhugo.finance_management.model.dto.LsBalanceDTO;
import com.torhugo.finance_management.model.entity.BalanceModel;
import com.torhugo.finance_management.util.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceMapper {

    @Autowired
    private ApplicationUtils applicationUtils;

    public BalanceModel mapper (BalanceDTO balanceDTO){
        BalanceModel balanceModel = new BalanceModel();
        balanceModel.setIdBalance(balanceDTO.getIdBalance());
        balanceModel.setIdCategory(balanceDTO.getIdCategory());
        balanceModel.setDescriptionBalance(balanceDTO.getDescriptionBalance());
        balanceModel.setBalanceValue(balanceDTO.getBalanceValue());
        balanceModel.setAdditionDate(applicationUtils.validationExistingDate(balanceDTO.getAdditionDate()));
        balanceModel.setTypeBalance(balanceDTO.getTypeBalance());
        balanceModel.setTypePayment(balanceDTO.getTypePayment());

        return balanceModel;
    }
}
