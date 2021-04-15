package com.chef.assist.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DeliveryVo {

    /**
     * 车牌号
     */
    private String CarNo;

    /**
     * 订单号
     */
    private String orderNumber;


    /**
     * 车辆当前所在位置
     */
    private String culocation;

    /**
     * 车辆的目的地
     */
    private String destination;

    /**
     * 配送人员名字
     */
    private String name;

    /**
     * 配送人员电话
     */
    private String phone;



}
