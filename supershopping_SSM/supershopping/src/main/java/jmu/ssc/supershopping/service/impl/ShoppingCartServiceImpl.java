package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.mapper.ShoppingCartMapper;
import jmu.ssc.supershopping.pojo.ShoppingCart;
import jmu.ssc.supershopping.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("shoppingCartService")

public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    //向购物车中添加商品
    public boolean isAddShoppingCart(int pid,int pcount,int uid){

        Map<String,Object> map = new HashMap<>();
        map.put("shoppingcart_pid",pid);
        map.put("shoppingcart_pcount",pcount);
        map.put("shoppingcart_uid",uid);

        int res = shoppingCartMapper.addShoppingCart(map);

        if(res>=1)
            return false;
        else
            return true;
    }

    //查看用户的购物车
    public List<ShoppingCart> getShoppingCartByUid(int id){

        return shoppingCartMapper.findShoppingCart(id);

    }

    //计算用户购物车中商品的总金额
    public Double getTotalPrice(int uid){

        return shoppingCartMapper.totalPrice(uid);

    }

    //删除购物车中的某个商品
    public boolean deleteCartShop(int uid,int pid){
        Map<String,Object> map = new HashMap<>();
        map.put("pid",pid);
        map.put("uid",uid);

        int row = shoppingCartMapper.deleteCartByUidAndPid(map);

        if(row>=1)
            return true;
        else
            return false;
    }

    //清空购物车
    public boolean deleteAllCart(int uid){

        int row = shoppingCartMapper.deleteAllCart(uid);
        if(row>=1) {
            return true;
        }
        else
            return false;
    }
}
