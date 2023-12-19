import jmu.ssc.supershopping.mapper.SortFirstMapper;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortFirst;
import jmu.ssc.supershopping.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSort {
    @Resource
    private SortFirstMapper sortMapper;

    @Resource
    private ProductService productService;

    @Test
    public void test(){
        List<SortFirst> sortList = sortMapper.findSortFirstAndSortSecond();
        for(SortFirst sortFirst : sortList) {
            System.out.println(sortFirst);
        }
    }

    @Test
    public void test1(){
        List<Product> pList= productService.findPopularProduct();
        System.out.println(pList);
    }

    @Test
    public void test2(){
        List<SortFirst> sortList = sortMapper.selectSortFirst();
        for(SortFirst sortFirst : sortList) {
            System.out.println(sortFirst);
        }
    }

    @Test
    public void test3(){

    }
}
