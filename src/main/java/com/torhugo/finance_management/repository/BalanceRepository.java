package com.torhugo.finance_management.repository;

import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceModel, Long> {
}
