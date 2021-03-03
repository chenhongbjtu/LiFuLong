package com.chef.assist.service.impl;

import com.chef.assist.mapper.ThMapper;
import com.chef.assist.model.Th;
import com.chef.assist.service.IThService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhong
 * @since 2021-03-01
 */
@Service
public class ThServiceImpl  implements IThService {

    @Autowired
    ThMapper thMapper;
    @Override
    public Th findThByName(String productName) {
     //   return thMapper.findThByName(productName);
        return thMapper.findThByName(productName);

    }
}
