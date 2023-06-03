package com.donkey.handler;

import com.donkey.infrastructure.exception.BusinessException;
import com.donkey.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.donkey.response.ExampleResultCode.FAIL;
import static com.donkey.response.ExampleResultCode.INVALID_PARAM;

/**
 * 全局异常处理类
 * @author liu'yao
 */
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * 拼接所有验证error message
     */
     private String listAllErrors(List<ObjectError> allErrors){
         StringBuilder errorMeg = new StringBuilder();
         allErrors.forEach(e -> errorMeg.append(e.getDefaultMessage()).append(" |"));

         return errorMeg.toString().substring(0,errorMeg.length()-2);

     }

    /**
     * 数据校验
     * 全局处理 {@link BindException}
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object handlerBindException(BindException be){
        List<ObjectError> allErrors = be.getAllErrors();
        log.error("数据校验参数错误::"+listAllErrors(allErrors),be);
        return BaseResponse.error(INVALID_PARAM,listAllErrors(allErrors));

    }

    /**
     * 数据校验
     * 全局处理 {@link MethodArgumentNotValidException}
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException mave) {
        List<ObjectError> allErrors = mave.getBindingResult().getAllErrors();
        log.error("数据校验参数错误::"+listAllErrors(allErrors),mave);
        return BaseResponse.error(INVALID_PARAM,listAllErrors(allErrors));
    }


    /**
     * 数据库操作异常
     */
    @ExceptionHandler({DataAccessException.class})
    @ResponseBody
    public Object handleDataAccessException(DataAccessException dae) {
        return BaseResponse.error(INVALID_PARAM,dae.getLocalizedMessage());
    }

    /**
     * 业务操作异常
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public Object handleBusinessException(BusinessException be) {
        return BaseResponse.error(be.getResultCode(), be.getDisplayMeg());
    }

    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object throwable(Throwable e) {
        log.error("全局异常信息::"+e.getMessage(),e);
        return BaseResponse.error(FAIL,e.getMessage());
    }

}
