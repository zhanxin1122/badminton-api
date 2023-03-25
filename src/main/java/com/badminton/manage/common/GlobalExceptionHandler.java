package com.badminton.manage.common;

import com.badminton.manage.dto.common.CommonResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@Component
//@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(BusinessException.class)
//    public ResultUtil businessExceptionHandler(BusinessException e){
//        log.error("BusinessException：{}",e);
//        return ResultUtil.failed(e.getCode(),e.getMessage(),e.getDescription());
//    }

//    @ExceptionHandler(RuntimeException.class)
//    public CommonResponseDTO runtimeExceptionHandler(RuntimeException e){
//        System.out.println("RuntimeException：{}");
//        System.out.println(e);
//        return new CommonResponseDTO(GlobalStatic.RESPONSE_LOGIN_FAIL, "登录失效");
//    }
}