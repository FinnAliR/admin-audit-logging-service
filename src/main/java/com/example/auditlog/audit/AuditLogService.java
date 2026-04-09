package com.example.auditlog.audit;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public AuditLog logAction(
            Long adminId,
            String adminName,
            ActionType actionType,
            EntityType entityType,
            String entityId,
            String description,
            String oldValue,
            String newValue
    ) {
        AuditLog log = new AuditLog();
        log.setAdminId(adminId);
        log.setAdminName(adminName);
        log.setActionType(actionType);
        log.setEntityType(entityType);
        log.setEntityId(entityId);
        log.setDescription(description);
        log.setOldValue(oldValue);
        log.setNewValue(newValue);
        log.setTimestamp(LocalDateTime.now());

        return auditLogRepository.save(log);
    }
}
