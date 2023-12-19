package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.AdminUser;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface AdminUserMapper {
    /*可以根据账号和密码查找管理员用户*/
    @Select("select * from admin where admin_account = #{admin_account} and admin_password = #{admin_password}")
    public List<AdminUser> selectAdminByAccountAndPassword(Map<String,Object> map);
}
