package com.uam.egresados.controller;

import com.uam.egresados.model.FormRecord;
import com.uam.egresados.service.IServiceFormRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/form-records")
public class FormRecordController {

    @Autowired
    private IServiceFormRecord formRecordService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<FormRecord>> getAllFormRecords() {
        List<FormRecord> records = formRecordService.getAll();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormRecord> getFormRecordByName(@RequestParam String name) {
        Optional<FormRecord> record = formRecordService.findByName(name);
        return record.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormRecord> getFormRecordById(@PathVariable String id) {
        Optional<FormRecord> record = formRecordService.findById(id);
        return record.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
