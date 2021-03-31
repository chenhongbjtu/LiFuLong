package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.mapper.ThMapper;
import com.chef.assist.mapper.ThWarnMapper;
import com.chef.assist.model.Th;
import com.chef.assist.model.dto.ThWarnDTO;
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

    @Autowired
    private ThMapper thMapper;

    @GetMapping
    public CaResponse ThWarning(@RequestParam("order_no") String order_no){

        Boolean tag = true;
        StringBuffer stringBuffer = new StringBuffer();

        /**
         * 1、根据订单号获取运输的所有物品
         */
       List<String> data = thWarnMapper.getProductNameByOrder(order_no);

        /**
         *2、根据订单编号从实时信息表里查询当前车辆的实时温度和实时湿度
         */

        ThWarnDTO temp = thWarnMapper.getTemperatureByOrder(order_no);
        //temp=[ThWarnDTO(temperature=23, humidity=60)]

        /**
         * 温度预警
         */
            for(String d : data){
                Th th = thMapper.findThByName(d);
                if(temp.getTemperature() <= th.getMin_temperature()){
                     tag =false;
                    stringBuffer.append("当前运输温度低于"+d+"运输的最低限值"+th.getMin_temperature()+";");
                 //    CaResponse.makeResponse(false,"当前运输温度低于"+d+"运输的最低限值"+th.getMin_temperature(),data);

                }
                else if(temp.getTemperature() >= th.getMax_temperature()) {
                    tag = false;
                    String str ="当前运输温度超过" + d + "运输的最高限值" + th.getMax_temperature()+";";
                    stringBuffer.append(str);

                 //   return CaResponse.makeResponse(false, "当前运输温度超过" + d + "运输的最高限值" + th.getMax_temperature(), data);
                }

        }

        return CaResponse.makeResponse(tag,stringBuffer.toString(),data);

    }

}
