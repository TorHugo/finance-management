package com.torhugo.finance_management.model.entity;

import com.torhugo.finance_management.model.enums.TypeBalance;
import com.torhugo.finance_management.model.enums.TypePayments;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_balance")
public class BalanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_balance")
    private Long idBalance;

    private String descriptionBalance;
    @Positive
    private BigDecimal balanceValue;
    private LocalDate additionDate;

    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "type_balance")
    private TypeBalance typeBalance;

    @Column(name = "type_payment")
    private TypePayments typePayment;
}
