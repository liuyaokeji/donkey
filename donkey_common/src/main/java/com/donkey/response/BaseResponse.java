package com.donkey.response;

import com.donkey.util.LocalDateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;

import static com.donkey.constant.Constants.REQUEST_ID;
import static com.donkey.constant.Constants.REQUEST_URI;

@Data
@Setter
@Getter
public class BaseResponse<T> {
    private String resultCode;
    private String displayMsg;
    private T data;
    private String requestId;
    private String path;
    private String serverTime;
    private String txId;
    public BaseResponse(){
        this.requestId = MDC.get(REQUEST_ID);
        this.serverTime = LocalDateUtils.getLocalDateTimeStr();
        this.txId = "111111";
    }

    public BaseResponse(ResultCode code){
        this.resultCode = code.getCode();
        this.requestId = MDC.get(REQUEST_ID);
        this.txId = "111111";
        this.serverTime = LocalDateUtils.getLocalDateTimeStr();
    }

    public BaseResponse(ResultCode code,String message) {
        this.resultCode = code.getCode();
        this.displayMsg = message;
        this.path = MDC.get(REQUEST_URI);
        this.requestId = MDC.get(REQUEST_ID);
        this.serverTime = LocalDateUtils.getLocalDateTimeStr();
        this.txId = "111111";
    }
    public BaseResponse(ResultCode code,T data,String message) {
        this.resultCode = code.getCode();
        this.data = data;
        this.displayMsg = message;
        this.path = MDC.get(REQUEST_URI);
        this.requestId = MDC.get(REQUEST_ID);
        this.serverTime = LocalDateUtils.getLocalDateTimeStr();
        this.txId = "111111";
    }

    /**
     * 传入状态常量 SUCCESS OR FAIL
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(){
        return new BaseResponse(ExampleResultCode.SUCCESS);
    }
    /**
     * 获取 添加成功返回data
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse(ExampleResultCode.SUCCESS,data,"success");
    }

    /**
     * 添加自定义message
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data,String message){
        return new BaseResponse(ExampleResultCode.SUCCESS,data,message);
    }

    /**
     * 删除成功不返回data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(String message){
        return new BaseResponse(ExampleResultCode.SUCCESS,null,message);
    }

    public static <T> BaseResponse<T> error(){
        return new BaseResponse(ExampleResultCode.FAIL);
    }


    public static <T> BaseResponse<T> error(T data){
        return new BaseResponse(ExampleResultCode.FAIL,data,"fail");
    }

    /**
     * 删除失败不返回data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> error(String message){
        return new BaseResponse(ExampleResultCode.FAIL,null,message);
    }


    public static <T> BaseResponse<T> error(ResultCode code,String message){
        return new BaseResponse(code,message);
    }

}
