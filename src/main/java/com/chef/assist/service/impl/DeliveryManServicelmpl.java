package com.chef.assist.service.impl;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.DeliveryManMapper;
import com.chef.assist.model.DeliveryVo;
import com.chef.assist.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryManServicelmpl implements DeliveryManService {

    @Qualifier("deliveryManMapper")
    @Autowired
    DeliveryManMapper deliveryManMapper;

    @Override
    public CaResponse findDeliveryMan() {

        List<DeliveryVo> deliveryVos = new ArrayList<>();
        deliveryVos = deliveryManMapper.findDeliverMan();
        //DeliveryVo deliveryVo = new DeliveryVo();
        Boolean flag = true;

        if(deliveryVos.isEmpty()){
            flag=true;
            return CaResponse.makeResponse(flag,"当前没有配送员的相关信息",deliveryVos);
        }



        return CaResponse.makeResponse(flag,"查询成功",deliveryVos);
    }
}
