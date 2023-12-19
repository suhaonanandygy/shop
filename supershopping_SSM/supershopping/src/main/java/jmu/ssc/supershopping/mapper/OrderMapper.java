package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    //用户提交订单，产生新的订单
    @Insert("INSERT INTO `order` VALUES (#{order_id},#{order_totalprice},#{order_state},#{order_receiveaddr},#{order_receivephone},now(),#{order_uid},#{order_accepter}) ")
    public int insertOrder(Order order);

    //用户确认订单后，修改订单的发货信息和订单状态
    @Update("UPDATE `order` SET order_state=1, order_receiveaddr=#{o_addr} ,order_receivephone=#{o_phone},order_accepter=#{o_accepter} WHERE order_id =#{o_id} ")
    public int updateOrder(Map<String,Object> map);

    //查看用户的所有订单信息
    public List<Order> findAllOrderByUid(int uid,int page, int limitPage);

    //查询用户订单数量
    @Select("SELECT count(*) FROM `order` WHERE `order`.order_uid=#{uid}")
    public int countOrderByUid(int uid);

    //根据订单编号查找订单的所有信息(多表查询)
    public Order findAllOrderByOid(String oid);

    //根据订单号修改订单状态
    @Update("UPDATE `order` SET order_state=3 WHERE order_id =#{o_id}")
    public int updateOrderStateByOid(String oid);

    /* -----------------------------------Admin--------------------------------------*/

    //根据订单状态，查询符合条件的记录条数
    int countOrdersByState(Integer state);

    //全部订单记录数
    int countAllOrders();

    List<Order> findAllOrderByPage(int page, int limitPage);

    @Update("update `order` set order_state = #{order_state} where order_id = #{order_id}")
    int updateByPrimaryKeySelective(Order record);

    //根据主键(order_id)查询
    @Select("select * from `order` where order_id = #{order_id}")
    public Order selectByPrimaryKey(String order_id);
}
