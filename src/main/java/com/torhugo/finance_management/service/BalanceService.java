package com.torhugo.finance_management.service;

import com.torhugo.finance_management.model.dto.BalanceDTO;
import com.torhugo.finance_management.model.dto.LsBalanceDTO;

import java.util.List;

public interface BalanceService {
    public List<BalanceDTO> savedLsBalance(LsBalanceDTO lsBalanceDTO);
}
