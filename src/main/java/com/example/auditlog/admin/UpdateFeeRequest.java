package com.example.auditlog.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class UpdateFeeRequest {
    @NotNull
    private Long adminId;

    @NotBlank
    private String adminName;

    @NotBlank
    private String feeCode;

    @NotNull
    private BigDecimal oldFee;

    @NotNull
    private BigDecimal newFee;

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

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public BigDecimal getOldFee() {
        return oldFee;
    }

    public void setOldFee(BigDecimal oldFee) {
        this.oldFee = oldFee;
    }

    public BigDecimal getNewFee() {
        return newFee;
    }

    public void setNewFee(BigDecimal newFee) {
        this.newFee = newFee;
    }
}
