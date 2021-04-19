package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.DeliveryManMapper;
import com.chef.assist.mapper.OrderMapper;
import com.chef.assist.model.DeliveryVo1;
import com.chef.assist.model.DetialVo;
import com.chef.assist.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/distribute")
public class DistributionController {

    @Qualifier("deliveryManMapper")
    @Autowired
     DeliveryManMapper deliveryManMapper;

    @Qualifier("orderMapper")
    @Autowired
    OrderMapper orderMapper;

    @GetMapping
    public CaResponse findAllCarNoAndOrder(){

        List<Order>  orders= orderMapper.findOrderNoCar();
        List<String> orderNumber = new ArrayList<>();

        for(Order r:orders){
            if(r.getCarNo()==null)
                orderNumber.add(r.getOrderNumber());
        }
        return CaResponse.makeResponse3(deliveryManMapper.findAllCarNo(),orderNumber);
    }

    @GetMapping("/insert")
    public String updateOrder(@RequestParam(value = "orderNo",required = true) String orderNo, @RequestParam(value = "carNo",required = true) String carNo ){
        orderMapper.updateCarNo(orderNo,carNo);
        return "订单分配成功";
    }

    @GetMapping("/findDetial")
    public CaResponse findDetial(){

        List<DetialVo> detialVos = orderMapper.findDetial();
        StringBuilder stringBuilder = new StringBuilder();
        List<StringBuilder> stringBuilders = new ArrayList<>(100);

        List<String> listNew = detialVos .stream().map(DetialVo::getCarNo).distinct().collect(Collectors.toList());

        System.out.println(listNew);

        List<String>  s1= new ArrayList<>();
        for(String carNo : listNew ){
            s1= orderMapper.findOrderByCarNo(carNo);
        }

        System.out.println(s1);
        return CaResponse.makeResponse(true,"查询成功",detialVos);
    }

}
