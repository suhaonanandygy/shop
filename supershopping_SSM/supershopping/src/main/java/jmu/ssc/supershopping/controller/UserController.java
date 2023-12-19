package jmu.ssc.supershopping.controller;

import com.mysql.jdbc.StringUtils;
import jmu.ssc.supershopping.pojo.User;
import jmu.ssc.supershopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialStruct;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("register")
    public String register() {
        return "/register";
    }

    @RequestMapping("login")
    public String login(){
        return "/login";
    }

    /*用户注册*/
    @RequestMapping("/user/register")
    public String register(User user, Model model) {
        boolean flag = false;

        String userName= user.getUser_name();
        String userPassword = user.getUser_password();
        String rePassword = user.getRePassword();
        String userRealname = user.getUser_realname();
        String userEmail = user.getUser_Email();
        String userPhone = user.getUser_phone();
        String userAddress = user.getUser_address();

        User user1 = userService.isUserAccountExist(userName);
        System.out.println(user);
        if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(userPassword)|| StringUtils.isNullOrEmpty(rePassword)){
            model.addAttribute("LOGIN_MSG", "用户账户名或密码为空请输入");
            return "/register";}
        else{
            if(!userPassword.equals(rePassword)){
                model.addAttribute("LOGIN_MSG", "两次密码不匹配请重新输入");
                return "/register";
            }
            else{
                if (user1 == null) //账户不存在，可以注册
                {
                    User user2 = new User();
                    user2.setUser_name(userName);
                    user2.setUser_password(userPassword);
                    user2.setUser_realname(userRealname);
                    user2.setUser_Email(userEmail);
                    user2.setUser_phone(userPhone);
                    user2.setUser_address(userAddress);
                    flag = userService.registerUser(user2);
                    System.out.println(flag);
                    if (flag) {
                        model.addAttribute("message", "注册成功请登录");
                        return "login";
                    } else { //注册失败，提示注册失败
                        model.addAttribute("LOGIN_MSG", "注册失败请重新输入");
                        return "/register";
                    }
                } else { //账户已存在
                    model.addAttribute("LOGIN_MSG", "用户账户名已存在请重新输入");
                    return "/register";
                }

            }


        }


}

    /*用户登录*/
    @RequestMapping("/user/login")
    public String login(User user, Model model, HttpSession session) {

        String userName = user.getUser_name();
        String userPassword = user.getUser_password();

        System.out.println(userName);

        //如果用户账户名或密码为空，提示，返回登录界面
        if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(userPassword)) {
            System.out.println(userPassword);
            model.addAttribute("LOGIN_MSG", "用户账户名或密码为空请输入");
            return "/login";
        } else {
            User user1 = userService.isUserAccountPasswordExist(userName, userPassword);
            System.out.println(user1);
            if (user1 == null) { //user为空，说明用户名和密码不匹配，未查到用户信息
                model.addAttribute("LOGIN_MSG", "用户账户名和密码不匹配请重新输入");
                return "/login";
            } else { //用户名和密码匹配
                //将用户放入session
                session.setAttribute("USER_SESSION", user1);
                //用户登录成功，转到主页面
                return "/main";
            }


        }

    }
    //退出登录
    @RequestMapping("/userExit")
    public String exit(){

        return "login";
    }


}
