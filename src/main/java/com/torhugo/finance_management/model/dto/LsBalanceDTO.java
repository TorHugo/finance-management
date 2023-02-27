package com.torhugo.finance_management.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LsBalanceDTO {

    private List<BalanceDTO> lsBalance;
}
