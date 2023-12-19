package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortSecond;

import java.util.List;

public interface SortSecondService {
    //查询二级分类下的商品
    public PageBean<Product> findProductBysortsecond_id(int sortsecond_id, int page) throws Exception;

    /* -----------------------------------Admin--------------------------------------*/


    //查询所有
    public List<SortSecond> findSortSecond();

    //	管理员分页查询所有的二级分类
    public PageBean <SortSecond> adminSortSecond_findAllByPage(int page);

    //添加
    public void adminSortSecond_save(SortSecond sortSecond) throws Exception;

    //根据ID查找二级分类
    public SortSecond findByCsid(int sortsecond_id)  throws Exception;

    //根据ID更新二级分类
    public void adminSortSecond_update(SortSecond sortSecond);

    //根据ID删除二级分类
    public void adminSortSecond_delete(int sortsecond_id) throws Exception;
}
