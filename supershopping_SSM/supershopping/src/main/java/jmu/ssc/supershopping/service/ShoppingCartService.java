package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    //向购物车中添加商品
    public boolean isAddShoppingCart(int pid, int pcount, int uid);

    //查看用户的购物车
    public List<ShoppingCart> getShoppingCartByUid(int id);

    //计算用户购物车中商品的总金额
    public Double getTotalPrice(int uid);

    //删除购物车中的商品
    public boolean deleteCartShop(int uid,int pid);

    //清空购物车
    public boolean deleteAllCart(int uid);
}
