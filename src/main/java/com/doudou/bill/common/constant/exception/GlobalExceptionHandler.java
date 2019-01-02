package com.doudou.bill.common.constant.exception;

import javax.servlet.http.HttpServletRequest;

import com.doudou.bill.common.constant.ResultCode;
import com.doudou.bill.common.dto.BillResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private  Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 捕捉自定义异常
     * @param req
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=GirlException.class)
    @ResponseBody
    public BillResult cangoAplExceptionHandler(HttpServletRequest req, Exception exception) throws Exception
    {
        exception.printStackTrace();
        BillResult outPutBean = new BillResult();
        GirlException cangoAplException = (GirlException)exception;
        outPutBean.setResultCode(cangoAplException.getErrorCode());
        outPutBean.setResultCode(cangoAplException.getMessage());
        return outPutBean;
    }

    /**
     * 捕捉系统异常
     * @param req
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BillResult defaultErrorHandler(HttpServletRequest req, Exception exception) throws Exception {
        
        exception.printStackTrace();
        BillResult outPutBean = new BillResult();
        outPutBean.setResultCode(ResultCode.SYS_ERR);
        outPutBean.setResultMsg("抛锚了,请联系管理员!");
        LOGGER.error("========[code:00001] 抛锚了,请联系管理员!======", exception);
        return outPutBean;
    }

    /**
     * 捕捉系统异常
     * @param req
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public BillResult SqlErrorHandler(HttpServletRequest req, SQLException exception) throws Exception {

        exception.printStackTrace();
        BillResult outPutBean = new BillResult();
        outPutBean.setResultCode(ResultCode.SYS_ERR);
        outPutBean.setResultMsg("抛锚了,请联系管理员!");
        LOGGER.error("========[code:00001] 抛锚了,请联系管理员!======", exception);
        return outPutBean;
    }
}
