package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Order;

import java.util.List;

public interface OrderService {
    //是否成功生成订单
    public boolean isInsertOrder(Order order);

    //是否成功修改订单信息
    public boolean payOrder(String o_addr,String o_phone,String o_accepter,String o_id);

    //分页查询用户的订单信息
    public PageBean<Order> findOrderByUidAndPage(int page, Integer uid);

    // 根据订单号查询订单信息
    public Order findOrderByOid (String oid);

    //根据订单号修改订单状态
    public boolean isUpdateOrderStateByOid(String oid);

    /* -----------------------------------Admin--------------------------------------*/

    //	后台：所有订单
    public PageBean<Order> findAllOrderByPage(int page) throws Exception;

    //更新订单状态
    public void updateOrderStatus(String oid, int status) throws Exception;




}
