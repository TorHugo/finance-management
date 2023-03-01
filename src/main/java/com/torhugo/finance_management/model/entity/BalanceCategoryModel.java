package com.torhugo.finance_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_balance_category")
public class BalanceCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "name_category")
    private String nameCategory;
    @Column(name = "description_category")
    private String descriptionCategory;
    @Column(name = "budget")
    private BigDecimal budget;
    @Column(name = "amount_spent")
    private BigDecimal amountSpent;

    @OneToMany
    private List<BalanceModel> lsBalance = new ArrayList<>();
}
