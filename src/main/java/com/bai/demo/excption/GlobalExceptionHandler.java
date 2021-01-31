package com.bai.demo.excption;

import com.bai.demo.HwipResponse;
import com.bai.demo.commom.I18nUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Validator;

/**
 * @Author BAI
 * @Description 统一异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
    * @Description: valid抛出的异常处理
    **/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public HwipResponse handler(MethodArgumentNotValidException e){
        StringBuilder b = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            //获取校验的信息
            b.append(error.getDefaultMessage()).append(",");
        }
        // 封装成自己固定的格式
        HwipResponse hwipResponse = new HwipResponse("400","bad request" ,b.toString());
        return hwipResponse;
    }

    /**
    * @Description: 自定义异常抛出统一处理
    **/
    @ExceptionHandler(value = HwipException.class)
    @ResponseBody
    public HwipResponse handler(HwipException e){
        // 封装成自己固定的格式
        HwipResponse hwipResponse = new HwipResponse(e.getCode(),
                e.getMessage()==null? I18nUtil.get(e.getCode()):e.getMessage()
                ,null);
        return hwipResponse;
    }

    @Autowired
    private MessageSource messageSource;
    /**
    * @Description:让validator具有国际化的能力
    **/
    @Bean
    public Validator getValidator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
