package com.torhugo.finance_management.repository;

import com.torhugo.finance_management.model.entity.BalanceCategoryModel;
import com.torhugo.finance_management.model.entity.BalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceModel, Long> {
    @Query(name = "SELECT * FROM tb_balance WHERE id_category = :idCategory", nativeQuery = true)
    List<BalanceModel> findAllByIdCategory(Long idCategory);
}
