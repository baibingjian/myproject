package com.bai.demo.commom;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * @Description 枚举接口  所有枚举继承该接口
 */
@JsonDeserialize(using = DescEnumDeserializer.class)
@JsonSerialize(using = DescEnumSerializer.class)
public interface I18nEnum {
    // 获取枚举描述
    String getDesc();
}
