package jmu.ssc.supershopping.service.impl;


import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.mapper.OrderMapper;
import jmu.ssc.supershopping.pojo.Order;
import jmu.ssc.supershopping.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    //是否成功生成订单
    public boolean isInsertOrder(Order order){

        int row = orderMapper.insertOrder(order);

        if(row>=1)
            return true;
        else
            return false;
    }

    //是否成功修改订单信息
    public boolean payOrder(String o_addr,String o_phone,String o_accepter,String o_id){
        Map<String,Object> map = new HashMap<>();

        map.put("o_addr",o_addr);
        map.put("o_phone",o_phone);
        map.put("o_id",o_id);
        map.put("o_accepter",o_accepter);

        int row = orderMapper.updateOrder(map);

        if (row>=1)
            return true;
        else
            return false;
    }

    //分页查询用户的订单信息
    public PageBean<Order> findOrderByUidAndPage(int page, Integer uid) {
        PageBean<Order> pageBean = new PageBean<>();
//		设置这是第几页
        pageBean.setPage(page);
//		设置4个
        int limitPage = 3;
        pageBean.setLimitPage(limitPage);

        int totlePage = 0;
//		查询一共有多少页
        totlePage = orderMapper.countOrderByUid(uid);

        if(Math.ceil(totlePage % limitPage)==0){
            totlePage = totlePage / limitPage;
        }else{
            totlePage=totlePage / limitPage+1;
        }
        pageBean.setTotlePage(totlePage);
        int beginPage= (page-1)*limitPage;
//		商品集合
        List<Order> list = orderMapper.findAllOrderByUid(uid,beginPage,limitPage);
        pageBean.setList(list);
        return pageBean;
    }

    // 根据订单号查询订单信息
    public Order findOrderByOid (String oid){

       return orderMapper.findAllOrderByOid(oid);

    }

    //根据订单号修改订单状态
    public boolean isUpdateOrderStateByOid(String oid){
        int row = orderMapper.updateOrderStateByOid(oid);

        if(row>=1)
            return true;
        else
            return false;
    }

    /* -----------------------------------Admin--------------------------------------*/

    //分页查找所有订单
    public PageBean<Order> findAllOrderByPage(int page)
            throws Exception {
        PageBean<Order> pageBean = new PageBean<>();
//		设置这是第几页
        pageBean.setPage(page);

        int limitPage = 20;
        pageBean.setLimitPage(limitPage);
//		设置一共多少页
        int totlePage = 0;
//		查询一共有多少页
        totlePage = orderMapper.countAllOrders();
        if(Math.ceil(totlePage % limitPage)==0){
            totlePage=totlePage / limitPage;
        }else{
            totlePage=totlePage / limitPage+1;
        }
        pageBean.setTotlePage(totlePage);
        int beginPage= (page-1)*limitPage;
        //商品集合
        List<Order> list = orderMapper.findAllOrderByPage(beginPage,limitPage);
        pageBean.setList(list);
        return pageBean;
    }

    //修改订单状态
    public void updateOrderStatus(String order_id, int status) throws Exception {
        Order payOrder = orderMapper.selectByPrimaryKey(order_id);
        payOrder.setOrder_state(status);
        orderMapper.updateByPrimaryKeySelective(payOrder);
    }


}
