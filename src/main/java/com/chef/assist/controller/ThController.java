package com.chef.assist.controller;


import com.chef.assist.config.CaResponse;
import com.chef.assist.model.Th;
import com.chef.assist.service.IThService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  温度前端控制器
 * </p>
 *
 * @author chenhong
 * @since 2021-03-01
 */
@RestController
@RequestMapping("/api/v1/th")
public class ThController {

    @Autowired
    IThService thService;
    /**
     * 根据产品名称查村运输的温湿度限值
     */
    @GetMapping
    public CaResponse findTemperature(@Valid  @RequestParam("productName") String productName){
        System.out.println("productName=" + productName);
         Th th = thService.findThByName(productName);
         if (StringUtils.isEmpty(th)) return CaResponse.makeResponse(false,"未查到改产品的相关信息",null);

        return CaResponse.makeResponse(true,"成功查询到温度限值",th);
    }



}
