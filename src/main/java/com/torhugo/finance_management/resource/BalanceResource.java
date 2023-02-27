package com.torhugo.finance_management.resource;

import com.torhugo.finance_management.model.dto.BalanceDTO;
import com.torhugo.finance_management.model.dto.LsBalanceDTO;
import com.torhugo.finance_management.service.BalanceService;
import com.torhugo.finance_management.util.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/balance")
public class BalanceResource {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private ApplicationResponse response;

    @PostMapping("/list")
    public ResponseEntity<List<BalanceDTO>> createdLsBalance(
            @RequestBody final LsBalanceDTO lsBalanceDTO){

        final List<BalanceDTO> lsBalance = balanceService.savedLsBalance(lsBalanceDTO);
        return ResponseEntity.status(response.created).body(lsBalance);
    }
}
