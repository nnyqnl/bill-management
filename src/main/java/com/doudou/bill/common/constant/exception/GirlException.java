package com.doudou.bill.common.constant.exception;


import com.doudou.bill.common.constant.ResultCode;

public class GirlException extends BaseException {


    /**
	 * 
	 */
	private static final long serialVersionUID = -7985515024842175509L;
	/**错误CODE*/
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 设定指定的Error
     * @param errorCode
     * @param message
     *
     */
    public GirlException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 默认系统异常 204
     * @param message
     */
    public GirlException(String message) {
        super(message);
        this.errorCode = ResultCode.BUSS_ERR;
    }
}
