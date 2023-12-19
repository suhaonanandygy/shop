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
public class SortFirst implements Serializable {
    private int sortfirst_id;
    private String sortfirst_name;

    //    关联二级目录
    private List<SortSecond> csList;
}
