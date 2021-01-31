package com.bai.demo.commom;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
/**
 * @Author BAI
 * @Description 国际化的工具类
 */
@Component
public class I18nUtil {

    private static MessageSource messageSource;

    public I18nUtil(MessageSource messageSource) {
        I18nUtil.messageSource = messageSource;
    }

    public static String get(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String get(String key, Object arg) {
        return messageSource.getMessage(key, new Object[]{arg}, LocaleContextHolder.getLocale());
    }
}
