package com.finance.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dashboard.model.FinancialRecord;
import com.finance.dashboard.service.FinancialRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;

    // CREATE RECORD
    @PostMapping
    public ResponseEntity<?> createRecord(
            @Valid @RequestBody FinancialRecord record,
            @RequestHeader("role") String role) //@RequesrParam 
    {
    	

        if (!role.equalsIgnoreCase("ADMIN")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access Denied: Only ADMIN can create records");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createRecord(record));
    }

    // GET ALL RECORDS
    @GetMapping
    public ResponseEntity<?> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    // DELETE RECORD
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecord(
            @PathVariable Long id,
            @RequestHeader("role") String role) // @RequesrParam 
    {

        if (!role.equalsIgnoreCase("ADMIN")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access Denied");
        }

        try {
            service.deleteRecord(id);
            return ResponseEntity.ok("Record deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    
 // UPDATE RECORD
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecord(
            @PathVariable Long id,
            @Valid @RequestBody FinancialRecord record) {

        try {
            FinancialRecord updated = service.updateRecord(id, record);
            return ResponseEntity.ok(updated);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    
    @GetMapping("/filter")
    public List<FinancialRecord> filterRecords(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category) {

        return service.filterRecords(type, category);
    }
    
    @GetMapping("/paginated")
    public ResponseEntity<?> getPaginatedRecords(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<FinancialRecord> records = service.getRecordsWithPagination(pageable);

        return ResponseEntity.ok(records.getContent());
    }
}