package com.chef.assist.model.dto;

import lombok.Data;

/**
 * @author chenhong
 * @create 2021/3/30
 * @desc
 */
@Data
public class ThWarnDTO {

    private Long temperature;

    private Long humidity;

    private String culocation;

}
