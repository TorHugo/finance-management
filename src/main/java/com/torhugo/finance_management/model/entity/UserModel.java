package com.torhugo.finance_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String name;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BalanceCategoryModel> lsBalanceCategory;
}
