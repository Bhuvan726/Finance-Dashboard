package com.finance.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finance.dashboard.model.FinancialRecord;
import com.finance.dashboard.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repository;

    // CREATE
    public FinancialRecord createRecord(FinancialRecord record) {
        return repository.save(record);
    }

    // GET ALL
    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    // DELETE
    public void deleteRecord(Long id) {
    	FinancialRecord record = repository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("Record not found with id " + id));

    	    repository.delete(record);
    }
    
 // UPDATE
    public FinancialRecord updateRecord(Long id, FinancialRecord newRecord) {
        return repository.findById(id).map(existing -> {
            existing.setAmount(newRecord.getAmount());
            existing.setType(newRecord.getType());
            existing.setCategory(newRecord.getCategory());
            existing.setDate(newRecord.getDate());
            existing.setNotes(newRecord.getNotes());
            existing.setUserId(newRecord.getUserId());

            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Record not found with id " + id));
    }
    
    public List<FinancialRecord> filterRecords(String type, String category) {

        if (type != null && category != null) {
            return repository.findByTypeAndCategory(type, category);
        } else if (type != null) {
            return repository.findByType(type);
        } else if (category != null) {
            return repository.findByCategory(category);
        } else {
            return repository.findAll();
        }
    }
    
    public Double getTotalIncome() {
        Double income = repository.getTotalIncome();
        return income != null ? income : 0.0;
    }

    public Double getTotalExpense() {
        Double expense = repository.getTotalExpense();
        return expense != null ? expense : 0.0;
    }

    public Double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }
    
    public Page<FinancialRecord> getRecordsWithPagination(Pageable pageable) {
        return repository.findAll(pageable);
    }
}