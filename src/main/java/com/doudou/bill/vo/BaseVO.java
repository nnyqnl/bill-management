package com.doudou.bill.vo;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseVO {
	
	/**
     * 返回code
     */
    private String resultCode;

    /**
     * 返回信息
     */
    private String resultMessage;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
    
    
}
