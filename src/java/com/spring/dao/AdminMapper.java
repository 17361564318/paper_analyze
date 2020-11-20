package com.spring.dao;

import com.base.MapperBase;
import com.spring.entity.Admin;

import org.springframework.stereotype.Repository;


@Repository
public interface AdminMapper extends MapperBase<Admin> {
    Admin login(Admin admin);
}
