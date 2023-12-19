package jmu.ssc.supershopping.mapper;

import jmu.ssc.supershopping.pojo.Message;

import java.util.List;

public interface MessageMapper {

    int deleteByPrimaryKey(int message_id);

    int insert(Message record);

    int insertSelective(Message record);

    //留言板全部记录数
    int countAllMessage();

    List<Message> findAllMessageByPage(int page, int limitPage);

}