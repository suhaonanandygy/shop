package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.mapper.SortFirstMapper;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortFirst;
import jmu.ssc.supershopping.service.SortFirstService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("sortService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SortFirstServiceImpl implements SortFirstService {

    @Resource
    private SortFirstMapper sortFirstMapper;

    //查询商品的一级分类和二级分类
    public List<SortFirst> findSort(){
        List<SortFirst> sortList = sortFirstMapper.findSortFirstAndSortSecond();
        if(sortList!=null && sortList.size()>0){
            return sortList;
        }
        return null;
    }

    //查询一级分类下的商品
    public PageBean<Product> findProductBySortfirst_id(int sortfirst_id, int page) throws Exception {
        PageBean<Product> pageBean = new PageBean<>();
//		设置这是第几页
        pageBean.setPage(page);
//		设置10个
        int limitPage =3;
        pageBean.setLimitPage(limitPage);
//		设置一共多少页
        int totlePage = 0;
//		查询一共有多少页
        totlePage = sortFirstMapper.countProductBySortfirst_id(sortfirst_id);
        if(Math.ceil(totlePage % limitPage)==0){
            totlePage=totlePage / limitPage;
        }else{
            totlePage=totlePage / limitPage+1;
        }
        pageBean.setTotlePage(totlePage);
        int beginPage= (page-1)*limitPage;
//		商品集合
        List<Product> list = sortFirstMapper.findProductBySortfirst_id(sortfirst_id,beginPage,limitPage);
        pageBean.setList(list);

        return pageBean;
    }

    /* -----------------------------------Admin--------------------------------------*/
    public List<SortFirst> findSortFirst()  {
        return sortFirstMapper.selectSortFirst();
    }

    //	增加一级目录
    public int addSortFirst(SortFirst sortFirst) throws Exception{
        int res = sortFirstMapper.insertSortFirst(sortFirst);
        return res;
    }

    //	根据sortfirst_id查询一级分类
    public SortFirst findSortFirstById(Integer sortfirst_id) throws Exception{
        return sortFirstMapper.selectByPrimaryKey(sortfirst_id);
    }
    //	更新一级分类
    public void adminFirstService_update(SortFirst sortFirst){
        sortFirstMapper.updateByPrimaryKey(sortFirst);
    }
    //	根据sortfirst_id删除一级分类
    public void deleteSortFirstByCid(int sortfirst_id) throws Exception{
        sortFirstMapper.deleteByPrimaryKey(sortfirst_id);
    }
}
