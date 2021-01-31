package com.bai.demo.excption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author BAI
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HwipException extends RuntimeException {
    private String code;
    private String message;
    public HwipException(String code) {
        this.code=code;
    }
}
