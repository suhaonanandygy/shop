package jmu.ssc.supershopping.controller;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Message;
import jmu.ssc.supershopping.pojo.User;
import jmu.ssc.supershopping.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {
    @Resource
    private MessageService messageService;

    @RequestMapping("/saveMessage")
    public String saveMessage(@RequestParam String messageinfo, HttpServletRequest request, Model model) throws Exception {
        Message Message = new Message();

        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");
        if (loginUser == null) {
            model.addAttribute("message", "对不起您还没有登录");
            return "msg";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Message.setMessage_contents(messageinfo);
        Message.setMessage_uid(loginUser.getUser_id());
        Message.setMessage_date(sdf.format(new Date()));

        messageService.insertMessage(Message);

        request.getSession().setAttribute("Message", Message);
        return "messageList";
    }

    // 显示留言板全部留言
    @RequestMapping("/messageList")
    public String messageList(@RequestParam int page, Model model, HttpServletRequest request) throws Exception {

        PageBean<Message> pageBean = messageService.findAllMessageByPage(page);
        model.addAttribute("pageBean", pageBean);
        return "messageList";
    }


}
