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
public class SortSecond implements Serializable {
    private int sortsecond_id;
    private String sortsecond_name;
    private int sortsecond_sortfid;
}
