package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.mapper.OrderItemMapper;
import jmu.ssc.supershopping.service.OrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderItemMapper orderItemMapper;

    //插入新的订单信息
    public boolean isInsertOrderItem(int oi_count,int oi_pid,String oi_oid){
        Map<String,Object> map = new HashMap<>();

        map.put("oi_count",oi_count);
        map.put("oi_pid",oi_pid);
        map.put("oi_oid",oi_oid);

        int row = orderItemMapper.insertOrderItem(map);

        if(row>=1)
            return true;
        else
            return false;

    }
}
