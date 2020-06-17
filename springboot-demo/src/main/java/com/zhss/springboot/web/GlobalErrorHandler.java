package com.zhss.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	ErrorInfo<String> r = new ErrorInfo<String>();  
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("自定义的全局异常处理");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}