package com.chef.assist.model;

import lombok.Data;

@Data
public class Deman {

    /**
     * 主键id,自增长
     */
    private Long id;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 运输人员名字
     */
    private String name;

    /**
     * 运输人员电话
     */
    private String phone;

}
