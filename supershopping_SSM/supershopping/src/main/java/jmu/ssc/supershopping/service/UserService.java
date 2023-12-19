package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.pojo.User;

import java.util.List;

public interface UserService {

    public boolean registerUser(User user);

    public User isUserAccountExist(String account);

    public User isUserAccountPasswordExist(String name, String password);

    /* -----------------------------------Admin--------------------------------------*/

    public List<User> getAllUsers();


}
