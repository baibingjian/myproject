package com.bai.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author BAI
 * @Description //TODO
 * @Class HwipResponse.Class
 * @Date 2021/1/30 17:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HwipResponse<T> {
    private String code;
    private String msg;
    private T data;
}
