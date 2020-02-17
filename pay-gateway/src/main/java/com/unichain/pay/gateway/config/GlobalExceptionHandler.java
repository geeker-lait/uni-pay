package com.unichain.pay.gateway.config;

import com.unichain.framework.common.ResponseData;
import com.unichain.framework.exception.UnichainException;
import com.unichain.pay.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @create 2019-08-10 03:41
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @time 03:48
     * @params
     */
    @ExceptionHandler(value = UnichainException.class)
    public ResponseData businessException(UnichainException e) {
        logger.error("拦截业务异常 >>> {}", e);
        return ResponseData.error(e.getMessage());
    }

    /**
     * @time 03:48
     * @params
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseData businessException(BusinessException e) {
        logger.error("拦截业务异常 >>> {}", e);
        return ResponseData.error(e.getMessage());
    }

//    /**
//     * @time 03:48
//     * @params
//     */
//    @ExceptionHandler(value = TokenException.class)
//    public ResponseData businessException(TokenException e) {
//        logger.error("拦截业务异常 >>> {}", e);
//        ResponseData<Object> error = ResponseData.error(e.getMessage());
//        return error.status(505);
//    }

    /**
     * 处理校验参数
     *
     * @time 22:39
     * @params e
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseData bindException(BindException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage() + "  ");
        }

        logger.error("参数校验错误 >>> {}", sb.toString());
        return ResponseData.error(sb.toString());
    }

    /**
     * 处理校验参数
     *
     * @time 22:39
     * @params e
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseData methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage() + "  ");
        }

        logger.error("参数校验错误 >>> {}", sb.toString());
        return ResponseData.error(sb.toString());
    }




    @ExceptionHandler(value = Exception.class)
    public ResponseData Exception(Exception e) {
        logger.error("出现未知异常 >>> {}", e);
        return ResponseData.error("服务器开小差");
    }
}
