package com.example.auditlog.admin;

import com.example.auditlog.audit.ActionType;
import com.example.auditlog.audit.AuditLogService;
import com.example.auditlog.audit.EntityType;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-actions")
public class AdminActionController {

    private final AuditLogService auditLogService;

    public AdminActionController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/approve-kyc")
    public String approveKyc(@Valid @RequestBody ApproveKycRequest request) {
        auditLogService.logAction(
                request.getAdminId(),
                request.getAdminName(),
                ActionType.APPROVE_KYC,
                EntityType.USER,
                request.getUserId(),
                "Approved KYC for user " + request.getUserId(),
                "PENDING_REVIEW",
                "APPROVED"
        );

        return "KYC approved and audit log created";
    }

    @PostMapping("/block-user")
    public String blockUser(@Valid @RequestBody BlockUserRequest request) {
        auditLogService.logAction(
                request.getAdminId(),
                request.getAdminName(),
                ActionType.BLOCK_USER,
                EntityType.USER,
                request.getUserId(),
                "Blocked user " + request.getUserId() + " for reason: " + request.getReason(),
                "ACTIVE",
                "BLOCKED"
        );

        return "User blocked and audit log created";
    }

    @PostMapping("/update-fee")
    public String updateFee(@Valid @RequestBody UpdateFeeRequest request) {
        auditLogService.logAction(
                request.getAdminId(),
                request.getAdminName(),
                ActionType.UPDATE_FEE,
                EntityType.FEE_CONFIG,
                request.getFeeCode(),
                "Updated fee config " + request.getFeeCode(),
                request.getOldFee().toString(),
                request.getNewFee().toString()
        );

        return "Fee updated and audit log created";
    }
}
