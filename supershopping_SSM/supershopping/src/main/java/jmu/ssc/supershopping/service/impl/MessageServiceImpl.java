package jmu.ssc.supershopping.service.impl;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.mapper.MessageMapper;
import jmu.ssc.supershopping.pojo.Message;
import jmu.ssc.supershopping.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public void insertMessage(Message messages) throws Exception {
        messageMapper.insert(messages);
    }

    @Override
    public PageBean<Message> findAllMessageByPage(int page) throws Exception {
        PageBean<Message> pageBean = new PageBean<>();
//		设置这是第几页
        pageBean.setPage(page);
//		设置10个
        int limitPage =4;
        pageBean.setLimitPage(limitPage);
//		设置一共多少页
        int totlePage = 0;
//		查询一共有多少页
        totlePage = messageMapper.countAllMessage();
        if(Math.ceil(totlePage % limitPage)==0){
            totlePage=totlePage / limitPage;
        }else{
            totlePage=totlePage / limitPage+1;
        }
        pageBean.setTotlePage(totlePage);
        int beginPage= (page-1)*limitPage;
        //商品集合
        List<Message> list = messageMapper.findAllMessageByPage(beginPage, limitPage) ;
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void deleteMessage(int message_id) throws Exception {
        messageMapper.deleteByPrimaryKey(message_id);
    }
}
