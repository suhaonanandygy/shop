import jmu.ssc.supershopping.mapper.OrderItemMapper;
import jmu.ssc.supershopping.mapper.OrderMapper;
import jmu.ssc.supershopping.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOrder {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;


    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();

        map.put("oi_count",1);
        map.put("oi_pid",403);
        map.put("oi_oid",501);

        orderItemMapper.insertOrderItem(map);
    }

    @Test
    public void test2(){
        Order order = new Order(20.02,0,"xx","1234",4);
        orderMapper.insertOrder(order);
    }

}
