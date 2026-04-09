package com.example.auditlog.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BlockUserRequest {
    @NotNull
    private Long adminId;

    @NotBlank
    private String adminName;

    @NotBlank
    private String userId;

    @NotBlank
    private String reason;

    // getters/setters

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
