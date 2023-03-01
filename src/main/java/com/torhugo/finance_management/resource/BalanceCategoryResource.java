package com.torhugo.finance_management.resource;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.model.dto.MonitoringBalanceDTO;
import com.torhugo.finance_management.service.BalanceCategoryService;
import com.torhugo.finance_management.util.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class BalanceCategoryResource {

    @Autowired
    private BalanceCategoryService service;

    @Autowired
    private ApplicationResponse response;

    @PostMapping
    public ResponseEntity<BalanceCategoryDTO> createdCategory(
            @RequestBody BalanceCategoryDTO userDTO) {
        BalanceCategoryDTO user = service.savedCategory(userDTO);
        return ResponseEntity.status(response.created).body(user);
    }

    @GetMapping("/monitoring")
    public ResponseEntity<MonitoringBalanceDTO> monitoring
            (@RequestParam Long idUser,
            @RequestParam Long idCategory){

        MonitoringBalanceDTO monitoringBalanceDTO =
                service.findAllMovimentsForCategory(idUser, idCategory);

        return ResponseEntity.status(response.created).body(monitoringBalanceDTO);
    }
}
