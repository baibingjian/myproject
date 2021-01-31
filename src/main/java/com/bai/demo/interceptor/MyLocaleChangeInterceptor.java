package com.bai.demo.interceptor;

import com.bai.demo.commom.I18nLocalResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author BAI
 * @Description 语言转化拦截器
 */
public class MyLocaleChangeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        I18nLocalResolver i18NLocalResolver = new I18nLocalResolver();
        Locale locale = i18NLocalResolver.resolveLocale(request);
        i18NLocalResolver.setLocale(request,response,locale);
        return true;
    }
}
