package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.mapper.AdminUserMapper;
import jmu.ssc.supershopping.pojo.AdminUser;
import jmu.ssc.supershopping.service.AdminUserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("/adminUserService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    public List<AdminUser> adminLogin(String admin_account, String admin_password) {
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("admin_account",admin_account);
            map.put("admin_password",admin_password);
            List<AdminUser> adminUserList = adminUserMapper.selectAdminByAccountAndPassword(map);
            System.out.println(adminUserList);
            return adminUserList;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}

