package jmu.ssc.supershopping.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface OrderItemMapper {

    //插入新的订单详单
    @Insert("INSERT INTO orderitem(orderitem_id,orderitem_count,orderitem_pid,orderitem_oid) VALUES(null,#{oi_count},#{oi_pid},#{oi_oid})")
    public int insertOrderItem(Map<String,Object> map);


}
