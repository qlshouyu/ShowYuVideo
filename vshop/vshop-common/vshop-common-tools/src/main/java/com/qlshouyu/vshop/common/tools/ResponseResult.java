package com.qlshouyu.vshop.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 高露 微信：18956074544
 * @Description 　接口结果
 * @date 19-5-28下午12:48
 */
public class ResponseResult<T> {
    private static Logger LOGGER= LoggerFactory.getLogger(ResponseResult.class);
    private T data;

    private RESPONSE_STATUS status;

    private int code;

    private String errorMsg;

    public ResponseResult(T data,RESPONSE_STATUS status,String error) {
        this.data=data;
        this.status=status;
        this.errorMsg=error;
        this.code=status.getValue();
    }

    public ResponseResult(T data) {
        this(data,RESPONSE_STATUS.SUCCESS,"");
    }

    public ResponseResult(Throwable throwable) {
        this((T) RESPONSE_STATUS.ERROR.getName(),RESPONSE_STATUS.ERROR,throwable.getMessage());
        LOGGER.warn("接口出错",throwable);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RESPONSE_STATUS getStatus() {
        return status;
    }

    public void setStatus(RESPONSE_STATUS status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


