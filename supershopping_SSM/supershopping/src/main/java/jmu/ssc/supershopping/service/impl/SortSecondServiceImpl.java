package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.mapper.SortSecondMapper;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortSecond;
import jmu.ssc.supershopping.service.SortSecondService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sortSecondService")
public class SortSecondServiceImpl implements SortSecondService {

    @Resource
    private SortSecondMapper sortSecondMapper;

    //查询二级分类下的商品
    public PageBean<Product> findProductBysortsecond_id(int sortsecond_id, int page) throws Exception {
        PageBean<Product> pageBean = new PageBean<>();
//		设置这是第几页
        pageBean.setPage(page);
//		设置10个
        int limitPage =3;
        pageBean.setLimitPage(limitPage);
//		设置一共多少页
        int totlePage = 0;
//		查询一共有多少页
        totlePage = sortSecondMapper.countProductBySortsecond_id(sortsecond_id);
        if(Math.ceil(totlePage % limitPage)==0){
            totlePage=totlePage / limitPage;
        }else{
            totlePage=totlePage / limitPage+1;
        }
        pageBean.setTotlePage(totlePage);
        int beginPage= (page-1)*limitPage;
//		商品集合
        List<Product> list = sortSecondMapper.findProductBySortSecond(sortsecond_id,beginPage,limitPage);
        pageBean.setList(list);

        return pageBean;
    }

    /* -----------------------------------Admin--------------------------------------*/
    //查询所有
    public List<SortSecond> findSortSecond(){
        return sortSecondMapper.selectSortSecond();
    }

    //	管理员分页查询所有的二级分类
    public PageBean<SortSecond> adminSortSecond_findAllByPage(int page){
        PageBean<SortSecond> pageBean = new PageBean<>();
        //设置当前是第几页
        pageBean.setPage(page);
        //设置一页4个
        int limitPage = 3;
        pageBean.setLimitPage(limitPage);
        //设置一共多少页
        int totalPage = 0;
        //查询一共多少页
        totalPage = sortSecondMapper.countAllSortSeconds();
        if (Math.ceil(totalPage % limitPage)==0){
            totalPage=totalPage/limitPage;
        }else {
            totalPage=totalPage/limitPage+1;
        }
        pageBean.setTotlePage(totalPage);

        int beginPage = 0;
        //二级分类集合
        page = (page-1)*limitPage;
        List<SortSecond> sortSecondList = sortSecondMapper.selectSortSecondByPage(page,limitPage);
        pageBean.setList(sortSecondList);
        return pageBean;
    }


    //添加
    public void adminSortSecond_save(SortSecond sortSecond) throws Exception{
        sortSecondMapper.insertSortSecond(sortSecond);
    }

    //根据ID查找二级分类
    public SortSecond findByCsid(int sortsecond_id)  throws Exception{
        return sortSecondMapper.selectByPrimaryKey(sortsecond_id);
    }

    //根据ID更新二级分类
    public void adminSortSecond_update(SortSecond sortSecond){
        sortSecondMapper.updateByPrimaryKey(sortSecond);
    }

    //根据ID删除二级分类
    public void adminSortSecond_delete(int sortsecond_id) throws Exception{
        sortSecondMapper.deleteByPrimaryKey(sortsecond_id);
    }

}
