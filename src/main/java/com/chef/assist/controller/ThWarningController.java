package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.ThWarnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenhong
 * @create 2021/3/30
 * @desc
 */

@RestController
@RequestMapping("/api/vi/thwarn")
public class ThWarningController {

    @Autowired
    private ThWarnMapper thWarnMapper;

    @GetMapping
    public List<String> ThWarning(@RequestParam("order_no") String order_no){
       // System.out.println(order_no);
       List<String> data = thWarnMapper.getProductNameByOrder(order_no);

       return data;

    }


}
