package com.bai.demo.commom;

import com.bai.demo.excption.I18nEnumException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.List;

/**
 * @Description 参数枚举化
 */
public class DescEnumDeserializer extends JsonDeserializer<I18nEnum> {

    @Override
    public I18nEnum deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        Class enumCls = BeanUtils.findPropertyType(p.currentName(), p.getCurrentValue().getClass());
        List enumFields = EnumUtils.getEnumList(enumCls);
        String keyPrefix = enumCls.getSimpleName() + ".";
        for (Object enumField : enumFields) {
            I18nEnum i18NEnum = (I18nEnum) enumField;
            // I18NUtil为国际化处理工具类
            String data = I18nUtil.get(keyPrefix + StringUtils.upperCase(i18NEnum.toString()), i18NEnum.getDesc());
            if (node.asText().equals(data)) {
                return i18NEnum;
            }
        }
        throw new I18nEnumException(keyPrefix+ "enum:未知的枚举类型");
    }
}
