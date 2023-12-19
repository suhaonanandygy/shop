package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /*添加一条用户信息*/
    @Insert(" insert into user values(null,#{user_name},#{user_password},#{user_realname},#{user_Email},#{user_phone},#{user_address})")
    public int insertUser(User user);

    //根据账户名判断用户是否存在
    @Select(" select * from user where user_name = #{name}")
    public User selectUserByAccount(String name);

    /*可以根据用户名和密码查找用户*/
    @Select("select * from user where user_name = #{user_name} and user_password = #{user_password}")
    public User selectUserByAccountAndPassword(Map<String,Object> map);

    //查看所有用户信息
    @Select("select * from user")
    public List<User> selectUser();


}
