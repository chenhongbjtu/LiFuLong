package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.DeliveryManMapper;
import com.chef.assist.mapper.OrderMapper;
import com.chef.assist.model.DeliveryVo1;
import com.chef.assist.model.DetialVo;
import com.chef.assist.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            if(orders.get(1).getCarNo() == null)
                orderNumber.add(orders.get(0).getOrderNumber());
        }
        return CaResponse.makeResponse3(deliveryManMapper.findAllCarNo(),orderNumber);
    }

    @GetMapping("/insert/{orderNo}/{carNo}")
    public String updateOrder(@PathVariable("orderNo") String orderNo,@PathVariable("carNo") String carNo){
        orderMapper.updateCarNo(orderNo,carNo);
        return "订单分配成功";
    }

    @GetMapping("/findDetial")
    public CaResponse findDetial(){

        List<DetialVo> detialVos = orderMapper.findDetial();
        StringBuilder stringBuilder = new StringBuilder();

        Set hs = new HashSet();


        for (DetialVo  detialVo: detialVos){
            hs.add(detialVo.getName());
             stringBuilder= stringBuilder.append(detialVo.getName()) ;
        }




        System.out.println(detialVos);




        return CaResponse.makeResponse(true,"查询成功",detialVos);
    }

}
