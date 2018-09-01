package com.doudou.bill.common.dto;

import com.doudou.bill.common.constant.ResultCode;

import java.io.Serializable;

public class BillResult implements Serializable {
    private String resultCode;
    private String resultMsg;
    private Object resultData;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public BillResult(String resultCode, String resultMsg, Object resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public BillResult() {
    }

    public BillResult(Object resultData) {
        this.setResultCode(ResultCode.SUCCESS);
        this.setResultMsg("success");
        this.resultData = resultData;
    }
    public static BillResult ok(Object data) {

        return new BillResult(data);
    }
}
