package jmu.ssc.supershopping.controller;

import jmu.ssc.supershopping.pojo.ShoppingCart;
import jmu.ssc.supershopping.pojo.User;
import jmu.ssc.supershopping.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    //向购物车中添加商品
    @RequestMapping("/addCart")
    public String addCart(HttpServletRequest request, @RequestParam int pid, @RequestParam int count , Model model){
        HttpSession httpSession = request.getSession();
        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");

        System.out.println(loginUser);

        //int uuid = loginUser.getUser_id();

        if(loginUser==null)
        {
            model.addAttribute("message","您还没有登录！");
            return "msg";
        }
        else{
            int uuid = loginUser.getUser_id();
            shoppingCartService.isAddShoppingCart(pid,count,uuid);
            return "cart";
        }

    }

    //查看用户购物车
    @RequestMapping("/myCart")
    public String myCart(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");

        System.out.println(loginUser);

        if (loginUser == null) {
            model.addAttribute("message","您还没有登录！");
            return "msg";
        }
        else{
            int uid = loginUser.getUser_id();
            List<ShoppingCart> cart = shoppingCartService.getShoppingCartByUid(uid);

            httpSession.setAttribute("cart", cart);
            System.out.println(cart);

            Double total = shoppingCartService.getTotalPrice(uid);
            System.out.println(total);
            httpSession.setAttribute("total",  total);

            return "cart";
        }

    }

    //删除购物车中的某个商品
    @RequestMapping("/deleteCartShop")
    public String delCartShop(@RequestParam int pid,HttpServletRequest request){

        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");

        int uid = loginUser.getUser_id();

        System.out.println(uid);

        shoppingCartService.deleteCartShop(uid,pid);

        return "cart";
    }

    //清空购物车
    @RequestMapping("/deleteAllCart")
    public String delAllShoppingCart(HttpServletRequest request){
        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");

        int uid = loginUser.getUser_id();

        shoppingCartService.deleteAllCart(uid);

        return "cart";

    }


}

//<input type="hidden" name="uid" value="${sessionScope.USER_SESSION.user_id}"></input>