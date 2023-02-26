package com.torhugo.finance_management.model.dto;

import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BalanceCategoryDTO {

    private Long idCategory;
    @NotBlank(message = "Requeired field!")
    private Long idUser;
    @NotBlank(message = "Requeired field!")
    private String nameCategory;
    @NotBlank(message = "Requeired field!")
    private String descriptionCategory;
    @NotBlank(message = "Requeired field!")
    @Positive
    private BigDecimal budget;

    public BalanceCategoryDTO(BalanceCategoryModel categoryModel) {
        this.idCategory = categoryModel.getIdCategory();
        this.nameCategory = categoryModel.getNameCategory();
        this.descriptionCategory = categoryModel.getDescriptionCategory();
        this.budget = categoryModel.getBudget();
        this.idUser = categoryModel.getIdUser();
    }
}
