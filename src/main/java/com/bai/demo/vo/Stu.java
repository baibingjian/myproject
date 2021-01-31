package com.bai.demo.vo;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @Author BAI
 * @Description //TODO
 * @Class Stu.Class
 * @Date 2021/1/26 22:53
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    @NotNull(message = "{id}")
    private Integer id;
    @NotBlank(message = "{name}")
    private String name;
    @NotNull(message = "{operateEnum}")
    private OperateEnum operateEnum;
}
