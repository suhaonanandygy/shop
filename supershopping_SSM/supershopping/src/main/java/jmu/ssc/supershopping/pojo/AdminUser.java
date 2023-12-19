package jmu.ssc.supershopping.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class AdminUser {
    private int admin_id;
    private String admin_account;
    private String admin_password;
}
