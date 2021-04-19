package com.chef.assist.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Data
public class DeliveryVo1 {

    private String carNo;
    private String name;
    private String phone;
    private List<String> orderNumber;
    private String temperature;
    private String humidity;
}
