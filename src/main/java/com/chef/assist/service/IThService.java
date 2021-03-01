package com.chef.assist.service;

import com.baomidou.mybatisplus.service.IService;
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
public interface IThService extends IService<Th> {

     Th findThByName(String productName);

}
