package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper {

    //向购物车中添加商品
    @Insert("Insert into shoppingcart(shoppingcart_id,shoppingcart_pid,shoppingcart_pcount,shoppingcart_uid) values (null,#{shoppingcart_pid},#{shoppingcart_pcount},#{shoppingcart_uid})")
    public int addShoppingCart (Map<String,Object> map);

    //查看用户的购物车
    @Select("Select * from shoppingcart where shoppingcart_uid = #{uid}")
    public List<ShoppingCart> findShoppingCart(int uid);

    //计算购物车中用户订单总价
    @Select("SELECT sum(shoppingcart_ptotal) from shoppingcart  WHERE shoppingcart_uid = #{uid}")
    public Double totalPrice(int uid);

    //根据商品Id和用户ID删除购物车中商品
    @Delete("Delete from shoppingcart where shoppingcart_uid = #{uid}  AND shoppingcart_pid = #{pid}")
    //public int deleteCartByUidAndPid(int uid,int pid);
    public int deleteCartByUidAndPid( Map<String,Object> map);

    //清空购物车
    @Delete("Delete from shoppingcart where shoppingcart_uid = #{uid}")
    public int deleteAllCart(int uid);

}
