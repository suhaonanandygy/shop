package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.pojo.SortFirst;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SortFirstMapper {
    /*查询商品的一级分类和二级分类*/
    public  List<SortFirst> findSortFirstAndSortSecond();

    //查询商品的一级分类
    @Select("select * from sortfirst")
    public List<SortFirst> selectSortFirst();

    //根据一级分类查询所属的所有的商品
    public List<Product> findProductBySortfirst_id(int sortfirst_id, int beginPage, int end);

    //查询一级分类下商品的总数
    public int countProductBySortfirst_id(int sortfirst_id);

    /* ------------------------Admin--------------------------------*/

    //插入一级分类
    @Insert("insert into sortfirst values(null,#{sortfirst_name})")
    public int insertSortFirst (SortFirst sortFirst);

    //修改一级分类
    @Update("update sortfirst set sortfirst_name=#{sortfirst_name} where sortfirst_id = #{sortfirst_id}")
    public int updateByPrimaryKey(SortFirst sortFirst);

    //删除一级分类
    @Delete("delete from sortfirst where sortfirst_id = #{sortfirst_id}")
    public int deleteByPrimaryKey(int sortfirst_id);

    //根据主键(sortfirst_id)查找一级分类
    @Select("select * from sortfirst where sortfirst_id = #{sortfirst_id}")
    SortFirst selectByPrimaryKey(Integer sortfirst_id);



}
