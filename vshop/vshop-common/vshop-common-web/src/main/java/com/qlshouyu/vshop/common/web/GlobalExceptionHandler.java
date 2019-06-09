package com.qlshouyu.vshop.common.web;

import com.qlshouyu.vshop.common.tools.RESPONSE_STATUS;
import com.qlshouyu.vshop.common.tools.ResponseResult;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 2019-06-07 14:48
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    // 方法参数校验异常
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult constraintViolationException(Exception e) {
        return new ResponseResult(e);
    }


    // Bean 校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult notValidExceptionHandler(MethodArgumentNotValidException e) throws Exception {
        if (e.getBindingResult() != null && !CollectionUtils.isEmpty(e.getBindingResult().getAllErrors())) {
            return new ResponseResult(RESPONSE_STATUS.ERROR_PARM.getName(), RESPONSE_STATUS.ERROR_PARM, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } else {
            return new ResponseResult(e);
        }
    }
}
