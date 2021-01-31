package com.bai.demo.vo;

import com.bai.demo.commom.I18nEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author BAI
 * @Description 操作类型枚举
 */
@Getter
@AllArgsConstructor
public enum OperateEnum implements I18nEnum {
    /**
     * 操作成功
     */
    SUCCESS(1, "SUCCESS",3),
    /**
     * 操作失败
     */
    FAIL(2,"FAIL",4);
    private int index;
    private String desc;
    private int outerVariable ;
}
