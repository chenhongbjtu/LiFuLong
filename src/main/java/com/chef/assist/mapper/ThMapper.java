package com.chef.assist.mapper;

import com.chef.assist.model.Th;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenhong
 * @since 2021-03-01
 */
@Mapper
@Repository
public interface ThMapper  {

//   @Select("select * from th\n" +
//           "    where name = #{name}")
    Th findThByName(String name);



}
