package com.chef.assist.mapper;

import com.chef.assist.model.dto.ThWarnDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenhong
 * @create 2021/3/30
 * @desc
 */
@Mapper
@Component(value = "thWarnMapper")
public interface ThWarnMapper {

    @Select("select name from ca_order a    " +
            "left join ca_order_item b on a.id = b.order_id     " +
            "left join ca_dish c on b.dish_id = c.id    " +
            " where a.order_no = #{order_no} ")
    @Results({
            @Result(property = "name",column = "name")
    })
    List<String> getProductNameByOrder(String order_no);

    @Select("select temperature, humidity from timeinformation      " +
            " where id=(select max(id) from timeinformation) and order_no =  #{order_no}")
    @Results({
            @Result(property = "temperature",column = "temperature"),
            @Result(property = "humidity",column = "humidity")
    })
    ThWarnDTO getTemperatureByOrder(String order_no);
}
