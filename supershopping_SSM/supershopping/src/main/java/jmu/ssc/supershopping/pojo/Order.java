package jmu.ssc.supershopping.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Order implements Serializable {
    private String order_id;
    private Double order_totalprice;
    private int order_state;
    private String order_receiveaddr;
    private String order_receivephone;
    private String order_accepter;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date order_time;
    private Integer order_uid;
    private User user;

    // 关联定单选项
    private List<OrderItem> oiList = new ArrayList<>();

    public Order( Double order_totalprice, int order_state, String order_receiveaddr, String order_receivephone, Integer order_uid) {
        //this.order_id = order_id;
        this.order_totalprice = order_totalprice;
        this.order_state = order_state;
        this.order_receiveaddr = order_receiveaddr;
        this.order_receivephone = order_receivephone;

        this.order_uid = order_uid;

    }
}
