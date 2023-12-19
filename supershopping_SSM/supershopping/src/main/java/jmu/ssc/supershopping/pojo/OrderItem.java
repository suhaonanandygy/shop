package jmu.ssc.supershopping.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderItem implements Serializable {
    private int orderitem_id;
    private Integer orderitem_count;
    private Double orderitem_unitprice;
    private Integer orderitem_pid;
    private String orderitem_oid;
    private Product product;
    private Order order;
}
