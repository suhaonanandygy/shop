package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.mapper.UserMapper;
import jmu.ssc.supershopping.pojo.User;
import jmu.ssc.supershopping.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    //插入一条用户信息
    public boolean registerUser(User user){
        int res =  userMapper.insertUser(user);
        if(res>=1)
            return  true;
        else
            return  false;
    }

    //判断用户是否存在
    public User isUserAccountExist(String account) {
        try{
            return userMapper.selectUserByAccount(account);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    //根据账户名和密码返回用户信息
    public User isUserAccountPasswordExist(String name, String password){
        try{
            Map<String,Object> map = new HashMap<>();
            map.put("user_name",name);
            map.put("user_password",password);
            User user = userMapper.selectUserByAccountAndPassword(map);
            System.out.println(user);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    /* -----------------------------------Admin--------------------------------------*/
    public List<User> getAllUsers(){
        return userMapper.selectUser();
    }


}
