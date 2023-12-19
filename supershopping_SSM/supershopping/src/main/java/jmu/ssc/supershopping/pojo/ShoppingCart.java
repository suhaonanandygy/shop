package jmu.ssc.supershopping.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ShoppingCart implements Serializable {

    private int shoppingcart_id;
    private int shoppingcart_pid;
    private String shoppingcart_pname;
    private String shoppingcart_pimage;
    private Double shoppingcart_pprice;
    private int shoppingcart_pcount;
    private Double shoppingcart_ptotal;
    private int shoppingcart_uid;

    private Double total;


}
