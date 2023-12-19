import jmu.ssc.supershopping.mapper.ShoppingCartMapper;
import jmu.ssc.supershopping.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCart {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Resource
    private ShoppingCartService shoppingCartService;

    @Test
    public void test(){
        int pid = 401;
        int pcount = 2;
        int uid = 1;
        boolean flag = shoppingCartService.isAddShoppingCart(pid,pcount,uid);
        System.out.println(flag);
    }



}
