package kr.co.acomp.hello.controller;

import kr.co.acomp.hello.exception.BizException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller 이면서 예외를 처리할 수 있는 클래스
@ControllerAdvice
public class GlobalExceptionHandler {
//    BizException을 처리할때 동작하도록
    @ExceptionHandler(BizException.class)
    public String handleBizException(Exception e, Model model){
//      예외 클래스명
        model.addAttribute("type",e.getClass().getSimpleName());
//      예외 메시지
        model.addAttribute("msg",e.getMessage());

        return "error";
    }

//    MyBatis Exception 처리 
    @ExceptionHandler(MyBatisSystemException.class)
    public String handleMyBatisSystemException(Exception e, Model model){
        model.addAttribute("type", e.getClass());
        model.addAttribute("msg",e.getMessage());
        return "error";
    }
}
