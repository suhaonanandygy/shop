package jmu.ssc.supershopping.controller;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.Utils.UUIDUtils;
import jmu.ssc.supershopping.pojo.Order;
import jmu.ssc.supershopping.pojo.ShoppingCart;
import jmu.ssc.supershopping.pojo.User;
import jmu.ssc.supershopping.service.OrderItemService;
import jmu.ssc.supershopping.service.OrderService;
import jmu.ssc.supershopping.service.ShoppingCartService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Data
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private OrderItemService orderItemService;

    @Resource
    private ShoppingCartService shoppingCartService;


    @RequestMapping("/addOrder")
    public String toOrder1(HttpServletRequest request, Model model,Order order) throws Exception {

        UUIDUtils uuidUtils = new UUIDUtils();

        Order orders = new Order();
        List<ShoppingCart> cartList = (List<ShoppingCart>) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");
        Double total = (Double) request.getSession().getAttribute("total");

        System.out.println(total);

        if(loginUser==null){
            model.addAttribute("message", "对不起您还没有登录");
            return "msg";
        }
        int uid = loginUser.getUser_id();

        String order_id = UUIDUtils.getOrderNum();
        orders.setOrder_id(order_id);
        orders.setOrder_state(0);
        orders.setOrder_totalprice(total);
        orders.setOrder_uid(loginUser.getUser_id());
        orders.setOrder_receiveaddr(order.getOrder_receiveaddr());
        orders.setOrder_receivephone(order.getOrder_receivephone());
        orders.setOrder_accepter(order.getOrder_accepter());

        orderService.isInsertOrder(orders);

        for(ShoppingCart cart : cartList){
            int oi_count = cart.getShoppingcart_pcount();
            int oi_pid = cart.getShoppingcart_pid();
            orderItemService.isInsertOrderItem(oi_count,oi_pid,order_id);
        }

        shoppingCartService.deleteAllCart(uid);
        Order orders1 = orderService.findOrderByOid(order_id);
        request.getSession().setAttribute("orders", orders1);
        return "order";
    }

    // 为定单付款
    @RequestMapping("/payOrder")
    public String payOrder(HttpServletRequest request, @RequestParam String o_receiveaddr, @RequestParam String o_receivephone, @RequestParam String o_accepter) throws Exception {
        Order order = ( Order) request.getSession().getAttribute("orders");
        String o_id = order.getOrder_id();
        orderService.payOrder(o_receiveaddr,o_receivephone,o_accepter,o_id);
        return "/main";
    }

    //查看我的订单信息
    @RequestMapping("/myOrder")
    public String myOrder(@RequestParam int page, Model model,HttpServletRequest request) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("USER_SESSION");

        System.out.println(loginUser);

        PageBean<Order> pageBean = orderService.findOrderByUidAndPage(page,loginUser.getUser_id());
        model.addAttribute("pageBean", pageBean);
        return "orderList";
    }

    //为我的订单中未付款的订单付款
    @RequestMapping("/payOrderAgain")
    public String payOrderAgain(@RequestParam(name = "oid",required = false) String oid,HttpServletRequest request){
        System.out.println(oid);
        Order noPayOrder = orderService.findOrderByOid(oid);

        System.out.println(noPayOrder);

        request.getSession().setAttribute("orders", noPayOrder);
        return "order";
    }

    //订单确认收货,修改订单状态为发货状态
    @RequestMapping("updateUserState")
    public String updateUser_OrderState(@RequestParam String oid){
        orderService.isUpdateOrderStateByOid(oid);
        return "redirect:myOrder?page=1";
    }




}
