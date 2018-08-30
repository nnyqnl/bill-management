package com.doudou.bill.common.constant;

public class ResultCode {
    /** 成功 */
    public static final String SUCCESS = "00000";
    /** 系统异常 （响应超时等）*/
    public static final String SYS_ERR = "00001";
    /** 登录异常（用户角色验证，token认证） */
    public static final String LOGING_ERR = "00002";
    /** 权限异常 （访问url权限）*/
    public static final String AUTH_ERR = "00003";
    /** 业务异常（业务抛出异常） */
    public static final String BUSS_ERR = "00004";
    /** 参数异常  */
    public static final String PARAM_ERR = "00005";
}
