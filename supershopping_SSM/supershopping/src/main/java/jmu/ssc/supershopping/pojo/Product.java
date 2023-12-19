package jmu.ssc.supershopping.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Product implements Serializable{
    private int product_id;
    private String product_name;
    private double product_originalprice;
    private double product_specialprice;
    private String product_image;
    private int product_popular;
    private Date product_date;
    private int product_sort;

    //二级分类关联商品
    private List<Product> pList;
}
