package com.torhugo.finance_management.model.dto;

import com.torhugo.finance_management.model.entity.BalanceModel;
import com.torhugo.finance_management.model.enums.TypeBalance;
import com.torhugo.finance_management.model.enums.TypePayments;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BalanceDTO {

    private Long idBalance;
    private Long idCategory;
    private String descriptionBalance;
    private BigDecimal balanceValue;
    private LocalDate additionDate;
    private TypeBalance typeBalance;
    private TypePayments typePayment;

    public BalanceDTO(BalanceModel balanceModel){
        this.idBalance = balanceModel.getIdBalance();
        this.idCategory = balanceModel.getIdCategory();
        this.descriptionBalance = balanceModel.getDescriptionBalance();
        this.balanceValue = balanceModel.getBalanceValue();
        this.additionDate = balanceModel.getAdditionDate();
        this.typeBalance = balanceModel.getTypeBalance();
        this.typePayment = balanceModel.getTypePayment();
    }

    public BalanceDTO(BalanceDTO balanceDTO) {
        this.idBalance = balanceDTO.getIdBalance();
        this.idCategory = balanceDTO.getIdCategory();
        this.descriptionBalance = balanceDTO.getDescriptionBalance();
        this.balanceValue = balanceDTO.getBalanceValue();
        this.additionDate = balanceDTO.getAdditionDate();
        this.typeBalance = balanceDTO.getTypeBalance();
        this.typePayment = balanceDTO.getTypePayment();
    }
}
