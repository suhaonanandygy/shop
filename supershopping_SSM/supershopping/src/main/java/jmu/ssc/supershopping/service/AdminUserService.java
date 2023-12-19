package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.pojo.AdminUser;

import java.util.List;

public interface AdminUserService {
    public List<AdminUser> adminLogin(String account,String password);
}
