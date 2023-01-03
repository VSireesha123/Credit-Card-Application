package com.crecard.execption;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(CustomerUserIdNotFoundException.class)
    public String exceptionHandler1(CustomerUserIdNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public String exceptionHandler1(CustomerAlreadyExistsException e) {
        return e.getMessage();
    }
    @ExceptionHandler(CustomException.class)
    public String exceptionHandler1(CustomException e) {
        return e.getMessage();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>handleMyException(MethodArgumentNotValidException ex)
    {
        Map<String,String> m=new LinkedHashMap<>();
        List<ObjectError> oerrors=ex.getAllErrors();
        oerrors.forEach(obj->{
            FieldError ferror=(FieldError)obj;
            String fname=ferror.getField();
            String message=ferror.getDefaultMessage();
            m.put(fname , message);
        });
        return m;
    }
}