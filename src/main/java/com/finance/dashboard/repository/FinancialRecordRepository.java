package com.finance.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finance.dashboard.model.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
	
	List<FinancialRecord> findByType(String type);

	List<FinancialRecord> findByCategory(String category);

	List<FinancialRecord> findByTypeAndCategory(String type, String category);
	
	@Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'INCOME'")
	Double getTotalIncome();

	@Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = 'EXPENSE'")
	Double getTotalExpense();
}