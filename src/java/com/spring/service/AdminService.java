package com.spring.service;

import com.base.IServiceBase;
import com.spring.entity.Admin;

public interface AdminService extends IServiceBase<Admin> {
    public Admin login(String username, String password);
    public boolean updatePassword(int id, String newPassword);
}
