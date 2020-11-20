package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.AdminMapper;
import com.spring.entity.Admin;
import com.spring.service.AdminService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("AdminService")
public class AdminServiceImpl extends ServiceBase<Admin> implements AdminService {
    @Resource
    private AdminMapper dao;

    @Override
    protected AdminMapper getDao() {
        return dao;
    }
    public Admin login(String username, String password) {
        Admin user = new Admin();
        user.setUsername(username);
            user.setPwd(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Admin user = new Admin();
        user.setId(id);
            user.setPwd(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }
}
