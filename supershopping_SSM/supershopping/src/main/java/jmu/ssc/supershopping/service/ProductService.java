package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Product;

import java.util.List;

public interface ProductService {

    //查询热门商品
    public List<Product> findPopularProduct();

    //查询最新商品
    public List<Product> findNewProduct();

    //根据商品id查找商品
    public Product getProductById(int id);

    //根据商品名字查询商品
    public List<Product> getProductByName(String p_name);

    /* -----------------------------------Admin--------------------------------------*/

    //	根据id查商品
    public Product findProductByPid(int pid);
    //	分页查找所有的商品
    public PageBean<Product> findAllProduct(int page) throws Exception;
    //	添加新增的商品
    public void adminProduct_save(Product product)throws Exception;
    //	删除商品
    public void adminProduct_deletecs(int pid)throws Exception;
    //	修改商品
    public void adminProduct_update(Product product)throws Exception;


}
