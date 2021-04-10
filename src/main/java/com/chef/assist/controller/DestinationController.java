package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.DestinationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenhong
 * @create 2021/4/1
 * @desc
 */
@RestController
@RequestMapping("/api/vi/getdestination")
public class DestinationController {
    @Autowired
    private DestinationMapper destinationMapper;

    @GetMapping
    public CaResponse Destination(@RequestParam("order_no") String order_no) {

        /**
         * 1、根据订单号获取物流详细信息（物品配送所在问题）
         */
        List<String> data = destinationMapper.getDestinationByOrder(order_no);
        return CaResponse.makeResponse2(data);

    }
}
