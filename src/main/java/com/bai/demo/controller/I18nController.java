package com.bai.demo.controller;

import com.bai.demo.excption.HwipException;
import com.bai.demo.vo.OperateEnum;
import com.bai.demo.vo.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @version 1.0
 * @Author BAI
 * @Description //TODO
 * @Class I18nController.Class
 * @Date 2021/1/26 22:24
 */
@RestController
@RequestMapping("/i18n")
@Slf4j
public class I18nController {
    
    @PostMapping(value = "/testStu")
    public Stu getStu(){
        Stu stu = Stu.builder().id(1).name("张三").operateEnum(OperateEnum.SUCCESS).build();
        return stu;
    }
    /**
    * @Description: 校验参数国际化 需要加上@Valid 注解
    * @Author: bai
    **/
    @PostMapping(value = "/queryByStu")
    public int queryByStu(@RequestBody @Valid Stu stu){
        log.info("stu:",stu.getOperateEnum());
        if (stu.getId() == 1) {
            throw new HwipException("E00001");
        }
        if (stu.getId() == 2) {
            throw new HwipException("E00001","自定义错误");
        }
        return 1;
    }
}
