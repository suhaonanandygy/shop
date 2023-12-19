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
public class User implements Serializable {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_realname;
    private String user_Email;
    private String user_phone;
    private String user_address;

    private String rePassword;

    private List<User> userList;

}