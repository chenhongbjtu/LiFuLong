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

   private String culocation;

    private String destination;

    @JsonProperty("order_no")
    private String orderNumber;

    private String carNo;


}
