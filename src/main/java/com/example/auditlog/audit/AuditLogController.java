package com.example.auditlog.audit;

import com.example.auditlog.common.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit-logs")
public class AuditLogController {

    private final AuditLogRepository auditLogRepository;

    public AuditLogController(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @GetMapping
    public List<AuditLog> getAll() {
        return auditLogRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }

    @GetMapping("/{id}")
    public AuditLog getById(@PathVariable Long id) {
        return auditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit log not found: " + id));
    }
}