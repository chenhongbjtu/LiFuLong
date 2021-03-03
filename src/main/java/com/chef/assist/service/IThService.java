package com.chef.assist.service;


import com.chef.assist.config.CaResponse;
import com.chef.assist.model.Th;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhong
 * @since 2021-03-01
 */
public interface IThService  {

     Th findThByName(String productName);

}
