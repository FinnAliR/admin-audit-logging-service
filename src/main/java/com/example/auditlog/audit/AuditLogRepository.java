package com.example.auditlog.audit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByAdminName(String adminName);
    List<AuditLog> findByActionType(ActionType actionType);
    List<AuditLog> findByAdminNameAndActionType(String adminName, ActionType actionType);
}