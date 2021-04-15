package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryManController {

    @Autowired
    DeliveryManService deliveryManService;

    @GetMapping
    public CaResponse findDeliveryMan(){
         return  deliveryManService.findDeliveryMan();
    }

}
