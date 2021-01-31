package com.bai.demo.commom;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author BAI
 * @Description 语言解析器
 */
@Component
public class I18nLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 从头部获取语言类型
        String lang = request.getHeader("lang");
        //获取jvm默认locale
        Locale locale;
        if (lang != null && "zh_CN".equals(lang)) {
            locale = Locale.SIMPLIFIED_CHINESE;
        }else {
            locale = Locale.US;
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // 设置语言环境的上下文
        LocaleContextHolder.setLocale(locale);
    }
}