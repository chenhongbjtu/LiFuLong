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
 * @create 2021/3/31
 * @desc
 */
@RestController
@RequestMapping("/api/vi/humiwarn")
public class HumiController {

    @Autowired
    private ThMapper thMapper;

    @Autowired
    private ThWarnMapper thWarnMapper;



    @GetMapping
    public CaResponse HumiWarning(@RequestParam("order_no") String order_no){

        Boolean tag = true;
        StringBuffer stringBuffer= new StringBuffer();

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
            if(temp.getHumidity() <= th.getMin_humidity()){

              //  return CaResponse.makeResponse(false,"当前运输湿度低于"+d+"运输的最低限值"+th.getMin_humidity(),data);
              tag = false;
              stringBuffer.append("当前运输湿度低于"+d+"运输的最低限值"+th.getMin_humidity()+";");
            }
            else if(temp.getHumidity() >= th.getMax_humidity()) {

              //  return CaResponse.makeResponse(false, "当前运输湿度超过" + d + "运输的最高限值" + th.getMax_humidity(), data);
              tag = false;
              stringBuffer.append("当前运输湿度超过" + d + "运输的最高限值" + th.getMax_humidity()+";");
            }

        }
        return CaResponse.makeResponse1(tag,stringBuffer.toString(),data,temp.getCulocation(),temp.getTemperature()+"°C",temp.getHumidity()+"%");
    }

}
