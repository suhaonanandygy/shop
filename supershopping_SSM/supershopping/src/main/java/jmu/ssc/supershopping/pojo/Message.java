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
public class Message implements Serializable {
    private int message_id;
    private String message_contents;
    private String message_date;
    private int message_uid;

//关联
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMessage_uid() {
        return message_uid;
    }

    public void setMessage_uid(int message_uid) {
        this.message_uid = message_uid;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) { this.message_id = message_id;}

    public String getMessage_contents() { return message_contents; }

    public void setMessage_contents(String message_contents) {
        this.message_contents = message_contents;
    }

    public String getMessage_date() { return message_date; }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

}


