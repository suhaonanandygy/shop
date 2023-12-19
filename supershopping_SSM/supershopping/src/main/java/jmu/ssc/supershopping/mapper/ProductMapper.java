package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {

    /*查询热门商品*/
    @Select("select * from product where product_popular = 1 LIMIT 4 OFFSET 0")
    public List<Product> findPopularProduct();

   /* 查询最新商品*/
   @Select("select * from product order by product_date DESC LIMIT 4 OFFSET 0")
   public List<Product> findNewProduct();

    /*根据商品Id查找商品*/
    @Select("select * from product where product_id = #{id}")
    public Product findProductById(int id);

    /*根据商品名字查询商品*/
    @Select("select * from product where product_name = #{p_name}")
    public List<Product> findProductByName(String p_name);

   /* ------------------------Admin--------------------------------*/

    //分页查询所有商品信息
    @Select("select * from product limit #{arg0},#{arg1}")
    public List<Product> selectProductByPage(int page, int limitPage);

    //根据主键(product_id)查询商品
    @Select("select * from product where product_id = #{product_id}")
    public Product selectProductByPrimaryKey(int product_id);

    //根据主键(product_id)更新商品
    @Update("UPDATE product SET product_name= #{product_name},product_originalprice = #{product_originalprice}, product_specialprice = #{product_specialprice},product_image = #{product_image},product_popular = #{product_popular} WHERE product_id = #{product_id}")
    public int updateByPrimaryKey(Product product);

    //根据主键(product_id)删除商品
    @Delete("delete from product where product_id = #{product_id}")
    public int deleteByPrimaryKey(int product_id);

    //插入数据
    @Insert("insert into product values(#{product_id},#{product_name},#{product_originalprice},#{product_specialprice},#{product_image},#{product_popular},now(), #{product_sort})")
    public int insertProduct(Product product);

    //查询所有信息
    @Select("select count(*) from product")
    public int countAllProduct();

}
