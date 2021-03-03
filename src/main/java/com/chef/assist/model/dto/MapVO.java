package com.chef.assist.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chenhong
 * @create 2021/3/3
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
public class MapVO {

    private String distance;
    private String time;

    public  MapVO (String distance,String time){
        this.distance =distance;
        this.time =time;
    }


}
