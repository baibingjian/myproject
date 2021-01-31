package com.bai.demo.commom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
/**
 * @Author BAI
 * @Description 枚举描述序列化 获取相应语言的指
 */
public class DescEnumSerializer extends JsonSerializer<I18nEnum> {

    @Override
    public void serialize(I18nEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // 按类名+枚举值名称拼接配置文件key，全部大写处理
        String key = value.getClass().getSimpleName() + "." + StringUtils.upperCase(value.toString());
        // I18NUtil为国际化处理工具类
        String data = I18nUtil.get(key, value.getDesc());
        gen.writeString(data);
    }
}
