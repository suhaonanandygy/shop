package jmu.ssc.supershopping.service;

import jmu.ssc.supershopping.pojo.Message;
import jmu.ssc.supershopping.Utils.PageBean;

public interface MessageService {
    public void insertMessage(Message messages) throws Exception;

    public void deleteMessage(int message_id) throws Exception;
    //	所有留言
    public PageBean<Message> findAllMessageByPage(int page) throws Exception;

}
