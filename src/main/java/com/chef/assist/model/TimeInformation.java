package com.chef.assist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author chenhong
 * @create 2021/3/30
 * @desc
 */
@Data
public class TimeInformation {

    private Long id;

    private Long temperature;

    private Long humidity;

    @JsonProperty("current_location")
    private String currentLocation;

    private String destination;

    @JsonProperty("order_no")
    private String orderNumber;



}
