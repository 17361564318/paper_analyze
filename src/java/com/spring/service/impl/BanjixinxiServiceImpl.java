package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.BanjixinxiMapper;
import com.spring.entity.Banjixinxi;
import com.spring.service.BanjixinxiService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("BanjixinxiService")
public class BanjixinxiServiceImpl extends ServiceBase<Banjixinxi> implements BanjixinxiService {
    @Resource
    private BanjixinxiMapper dao;

    @Override
    protected BanjixinxiMapper getDao() {
        return dao;
    }
}
