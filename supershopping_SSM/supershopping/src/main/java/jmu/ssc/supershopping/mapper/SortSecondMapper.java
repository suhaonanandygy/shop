package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortSecond;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SortSecondMapper {
    //查询二级分类下的商品
    public List<Product> findProductBySortSecond(int sortdecond_id, int beginPage, int end);

    //计算二级分类下商品的数量
    public int countProductBySortsecond_id(int sortsecond_id);

    /* -----------------------------------Admin--------------------------------------*/

    //查询所有二级分类
    @Select("select * from sortsecond")
    public List<SortSecond> selectSortSecond();

    //分页查询所有二级分类
    @Select("select * from sortsecond limit #{arg0},#{arg1}")
    public List<SortSecond> selectSortSecondByPage(int page, int limitPage);

    //查询二级分类信息数
    @Select("select count(*) from sortsecond")
    public int countAllSortSeconds();


    @Delete("delete from sortsecond where sortsecond_id = #{sortsecond_id}")
    public int deleteByPrimaryKey(int sortsecond_id);

    @Select("select * from sortsecond where sortsecond_id = #{sortsecond_id}")
    SortSecond selectByPrimaryKey(Integer sortsecond_id);

    @Insert("insert into sortsecond values(null,#{sortsecond_name},#{sortsecond_sortfid})")
    public int insertSortSecond (SortSecond sortSecond);

    @Update("update sortsecond set sortsecond_name=#{sortsecond_name} where sortsecond_id = #{sortsecond_id}")
    public int updateByPrimaryKey(SortSecond sortSecond);
}
