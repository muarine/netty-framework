package com.muarine.gateway.model;

import java.io.Serializable;

public class InvokeRecordWithBLOBs extends InvokeRecord implements Serializable {
    private String commonParam;

    private String businessParam;

    private String businessReturn;

    private static final long serialVersionUID = 1L;

    public String getCommonParam() {
        return commonParam;
    }

    public void setCommonParam(String commonParam) {
        this.commonParam = commonParam == null ? null : commonParam.trim();
    }

    public String getBusinessParam() {
        return businessParam;
    }

    public void setBusinessParam(String businessParam) {
        this.businessParam = businessParam == null ? null : businessParam.trim();
    }

    public String getBusinessReturn() {
        return businessReturn;
    }

    public void setBusinessReturn(String businessReturn) {
        this.businessReturn = businessReturn == null ? null : businessReturn.trim();
    }
}