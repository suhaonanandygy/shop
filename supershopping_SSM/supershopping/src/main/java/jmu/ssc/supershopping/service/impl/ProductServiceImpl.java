package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.mapper.ProductMapper;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    //查询热门商品
    public List<Product> findPopularProduct(){
        List<Product> plist = productMapper.findPopularProduct();
        return plist;
    }

    //查询最新商品
    public List<Product> findNewProduct(){
        List<Product> nlist = productMapper.findNewProduct();
        return nlist;
    }

    //根据商品id查找商品
    public Product getProductById(int id){
        Product product = productMapper.findProductById(id);
        return product;
    }

    //根据商品名字查询商品
    public List<Product> getProductByName(String p_name){
        List<Product> productList = productMapper.findProductByName(p_name);
        return productList;
    }

    /* -----------------------------------Admin--------------------------------------*/

    //	根据id查商品
    public Product findProductByPid(int product_id){
        return productMapper.selectProductByPrimaryKey(product_id);
    }
    //	分页查找所有的商品
    public PageBean<Product> findAllProduct(int page) throws Exception{
        PageBean<Product> pageBean = new PageBean<>();
        //设置当前是第几页
        pageBean.setPage(page);
        //设置一页5个
        int limitPage = 5;
        pageBean.setLimitPage(limitPage);
        //设置一共多少页
        int totalPaage = 0;
        //查询一共多少页
        totalPaage = productMapper.countAllProduct();
        if(Math.ceil(totalPaage % limitPage)==0){
            totalPaage = totalPaage/limitPage;
        }else {
            totalPaage=totalPaage/limitPage+1;
        }
        pageBean.setTotlePage(totalPaage);
        page = (page-1)*limitPage;
        //商品列表
        List<Product> productList = productMapper.selectProductByPage(page,limitPage);
        pageBean.setList(productList);
        return pageBean;
    }
    //	添加新增的商品
    public void adminProduct_save(Product product)throws Exception{
        productMapper.insertProduct(product);
    }
    //	删除商品
    public void adminProduct_deletecs(int product_id)throws Exception{
        productMapper.deleteByPrimaryKey(product_id);
    }
    //	修改商品
    public void adminProduct_update(Product product)throws Exception{
        productMapper.updateByPrimaryKey(product);
    }


}
