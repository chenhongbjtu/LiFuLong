package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.map.GetDistance;
import com.chef.assist.mapper.DestinationMapper;
import com.chef.assist.mapper.ThWarnMapper;
import com.chef.assist.model.dto.MapVO;
import com.chef.assist.model.dto.ThWarnDTO;
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
@RequestMapping("/api/v1/time")
public class TimeCuController {

    @Autowired
    private DestinationMapper destinationMapper;

    @Autowired
    private ThWarnMapper thWarnMapper;

    GetDistance getDistance = new GetDistance();
    MapVO mapVO = new MapVO();

    @GetMapping
    public CaResponse Destination(@RequestParam("order_no") String order_no) {

        /**
         * 1、根据订单号获取物流详细信息（物品配送所在问题）
         */
        List<String> data = destinationMapper.getDestinationByOrder(order_no);

        ThWarnDTO temp = thWarnMapper.getTemperatureByOrder(order_no);


        String start =  temp.getCulocation();
        String end = data.get(0);

        return findDistancTime(start,end);

    }

    public CaResponse findDistancTime(String start, String end) {

        String startLonLat = getDistance.getLonLat(start);
        String endLonLat = getDistance.getLonLat(end);

        Long distance = getDistance.getDistan(startLonLat, endLonLat);
        Long time = getDistance.getTime(startLonLat, endLonLat);

        int d = (int) (distance / 1000);

        int h = (int) (time / 3600);
        int m = (int) (time % 3600) / 60;

        String d1 = String.valueOf(d) + "公里";
        String time1 = String.valueOf(h) + "小时" + String.valueOf(m) + "分";

        mapVO.setDistance(d1);
        mapVO.setTime(time1);

        return CaResponse.makeResponse(true, "返回两地距离以及驾车时间", mapVO);
    }

}
