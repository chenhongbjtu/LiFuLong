package com.chef.assist.controller;

import com.chef.assist.config.CaResponse;
import com.chef.assist.map.GetDistance;
import com.chef.assist.model.dto.MapVO;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author chenhong
 * @create 2021/3/3
 * @desc
 */
@RestController
@RequestMapping("/api/v1/map")
public class MapController {

    GetDistance getDistance = new GetDistance();
    MapVO mapVO = new MapVO();
    @GetMapping
    public CaResponse findDistancTime(@RequestParam(value = "start",required = true) String start,@RequestParam(value = "end",required = true) String end){

        String startLonLat = getDistance.getLonLat(start);
        String endLonLat = getDistance.getLonLat(end);

        Long distance = getDistance.getDistan(startLonLat,endLonLat);
        Long time = getDistance.getTime(startLonLat,endLonLat);

        int d = (int) (distance/1000);

        int h = (int)(time/3600);
        int m =  (int)(time%3600)/60;

        String d1 = String.valueOf(d) +"公里";
        String time1 = String.valueOf(h) +"小时" +String.valueOf(m) +"分";

        mapVO.setDistance(d1);
        mapVO.setTime(time1);

        return CaResponse.makeResponse(true,"返回两地距离以及驾车时间",mapVO);
    }


}
