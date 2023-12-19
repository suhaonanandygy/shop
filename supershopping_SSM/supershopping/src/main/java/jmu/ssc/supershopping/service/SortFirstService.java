package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortFirst;

import java.util.List;

public interface SortFirstService {
    /*查询一级目录和二级目录*/
    public List<SortFirst> findSort();

    //查询一级分类下的商品
    public PageBean<Product> findProductBySortfirst_id(int sortfirst_id, int page) throws Exception;

    /* -----------------------------------Admin--------------------------------------*/

    //	查询一级目录
    public List<SortFirst> findSortFirst();

    //	增加一级目录
    public int  addSortFirst(SortFirst sortFirst) throws Exception;

    //	根据sortfirst_id查询一级分类
    public SortFirst findSortFirstById(Integer sortfirst_id) throws Exception;

    //	更新一级分类
    public void adminFirstService_update(SortFirst sortFirst);

    //	根据sortfirst_id删除一级分类
    public void deleteSortFirstByCid(int sortfirst_id) throws Exception;

}
