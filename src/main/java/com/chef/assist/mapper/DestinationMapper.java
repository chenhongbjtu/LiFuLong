package com.chef.assist.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenhong
 * @create 2021/4/1
 * @desc
 */
@Mapper
@Component(value = "destinationMapper")
public interface DestinationMapper {
    @Select("select destination from timeinformation "+
            " where order_no = #{order_no} and id = (select max(id) from timeinformation where order_no = #{order_no})")
    @Results({
            @Result(property = "destination",column = "destination")
    })
    List<String> getDestinationByOrder(String order_no);
}
