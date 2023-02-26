package com.torhugo.finance_management.resource;

import com.torhugo.finance_management.model.dto.BalanceCategoryDTO;
import com.torhugo.finance_management.service.BalanceCategoryService;
import com.torhugo.finance_management.util.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class BalanceCategoryResource {

    @Autowired
    private BalanceCategoryService service;

    @Autowired
    private ApplicationResponse response;

    @PostMapping
    public ResponseEntity<BalanceCategoryDTO> createdCategory(
            @RequestBody BalanceCategoryDTO userDTO) throws Exception {
        BalanceCategoryDTO user = service.savedCategory(userDTO);
        return ResponseEntity.status(response.created).body(user);
    }
}
