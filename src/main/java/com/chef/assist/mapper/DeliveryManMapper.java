package com.chef.assist.mapper;

import com.chef.assist.model.DeliveryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "deliveryManMapper")
public interface DeliveryManMapper {

    @Select("select t.carNo,t.order_no,t.culocation,t.destination,d.name,d.phone from timeinformation t, deman d\n" +
            "where t.carNo = d.carNo")
    @Results({
            @Result(property = "carNo",column = "carNo"),
            @Result(property = "orderNumber",column = "order_no"),
            @Result(property = "culocation",column = "culocation"),
            @Result(property = "destination",column = "destination"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone")
    })
    List<DeliveryVo> findDeliverMan();
}
