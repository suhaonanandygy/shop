package jmu.ssc.supershopping.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.Utils.UUIDUtils;
import jmu.ssc.supershopping.pojo.*;
import jmu.ssc.supershopping.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Resource
    private AdminUserService adminUserService;

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    @Resource
    private SortFirstService sortFirstService;

    @Resource
    private SortSecondService sortSecondService;

    @Resource
    private ProductService productService;


    //登录
    @GetMapping("/adminLogin")
    public String adminLogin(AdminUser adminUser, Model model, HttpSession session){
        String adminAccount = adminUser.getAdmin_account();
        String adminPassword = adminUser.getAdmin_password();

        System.out.println(adminAccount);
        System.out.println(adminPassword);
        //如果用户账户名或密码为空，提示，返回登录界面
        if (StringUtils.isNullOrEmpty(adminAccount) || StringUtils.isNullOrEmpty(adminPassword)) {
            model.addAttribute("LOGIN_MSG", "用户账户名或密码为空请重新输入");
            return "redirect:/adminLogin.jsp";
        } else {
            List<AdminUser> adminList = adminUserService.adminLogin(adminAccount, adminPassword);
            System.out.println(adminList);
            if (adminList == null || adminList.size() == 0) { //说明用户名和密码不匹配
                model.addAttribute("LOGIN_MSG", "用户账户名和密码不匹配请重新输入");
                return "redirect:/adminLogin.jsp";

            } else { //用户名和密码匹配
                //将用户放入session
                session.setAttribute("Admin_SESSION", adminList);
                //用户登录成功，转到首页
                return "redirect:/adminjsp/admin_main.jsp";
            }


        }
    }
    //返回主界面
    @GetMapping("/return")
    public String returnURL(){
        return "redirect:/adminjsp/admin_main.jsp";
    }

    //退出登录
    @GetMapping("/exit")
    public String exit(){
        return "main";
    }


    //查询用户信息
    @GetMapping("/find_allUser")
    public ModelAndView findAllUser(@RequestParam(name = "page",required = false,defaultValue = "1")Integer page,
                                    @RequestParam(name = "size",required = false,defaultValue = "4")Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        //分页查询
        PageHelper.startPage(page,size);
        List<User> userList = userService.getAllUsers();
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("users-page-list");
        return mv;
    }

    //查询订单列表
    @GetMapping("/adminOrder_findAllOrderByPage")
    public String adminOrder_findAllOrderByPage(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Model model,HttpServletRequest request)
            throws Exception {


        PageBean <Order> allProPageBean = orderService.findAllOrderByPage(page);
       // model.addAttribute("pageBean", allProPageBean);
        HttpSession session = request.getSession();
        session.setAttribute("pageBean",allProPageBean);
        return "redirect:/adminjsp/order/list.jsp";
    }

    //更新订单状态
    @GetMapping("/adminOrder_updateState")
    public String adminOrder_updateState(@RequestParam String order_id, @RequestParam int status, Model model,HttpServletRequest request)
            throws Exception {

        orderService.updateOrderStatus(order_id, status);

        return "redirect:/admin/adminOrder_findAllOrderByPage?page=1";
    }



    /*一级分类管理*/
    //一级分类列表
    @GetMapping("/adminSortFirst_findAll")
    public String adminCategory_findAll(Model model, HttpServletRequest request)
            throws Exception {

        List<SortFirst> sortFirstList = sortFirstService.findSortFirst();
        System.out.println(sortFirstList);

//        model.addAttribute("sortFirstList", sortFirstList);
        HttpSession session = request.getSession();
        session.setAttribute("sortFirstList",sortFirstList);
        return "redirect:/adminjsp/sortfirst/list.jsp";
    }

    //添加一级分类
    @GetMapping("/adminSortFirst_add")
    public String adminCategory_add(Model model,HttpServletRequest request) throws Exception {

//		List<Category> categoryList = categoryService.adminbFindCategory();
//		model.addAttribute("categoryList", categoryList);
        return "redirect:/adminjsp/sortfirst/add.jsp";
    }

    @GetMapping("/adminSortFirst_save")
    public String adminCategory_save(@RequestParam(name = "sortfirst_name",required = false) String sortfirst_name,HttpServletRequest request)
            throws Exception {

        SortFirst addSortFirst = new SortFirst();
        addSortFirst.setSortfirst_name(sortfirst_name);
        sortFirstService.addSortFirst(addSortFirst);
        return "redirect:/admin/adminSortFirst_findAll";
    }

    //编辑一级分类
    @GetMapping("/adminSortFirst_edit")
    public String adminSortFirst_delete(@RequestParam(name = "sortfirst_id",required = false) Integer sortfirst_id, Model model,HttpServletRequest request)
            throws Exception {

        SortFirst existSortFirst = sortFirstService.findSortFirstById(sortfirst_id);
        System.out.println(sortfirst_id);
        HttpSession session = request.getSession();
        session.setAttribute("existSortFirst",existSortFirst);

        return "redirect:/adminjsp/sortfirst/edit.jsp";
    }


    @GetMapping("/adminSortFirst_update")
    public String adminCategory_update(@RequestParam(name = "sortfirst_id",required = false) Integer sortfirst_id,
                                       @RequestParam(name = "sortfirst_name",required = false) String sortfirst_name,HttpServletRequest request) {

        SortFirst sortFirst = new SortFirst();
        sortFirst.setSortfirst_id(sortfirst_id);
        sortFirst.setSortfirst_name(sortfirst_name);
        sortFirstService.adminFirstService_update(sortFirst);
        return "redirect:/admin/adminSortFirst_findAll";
    }

    //删除一级分类
    @GetMapping("/adminSortFirst_delete")
    public String adminSortFirst_delete(@RequestParam(name = "sortfirst_id",required = false) int sortfirst_id,HttpServletRequest request) throws Exception {
        System.out.println(sortfirst_id);
        sortFirstService.deleteSortFirstByCid(sortfirst_id);
        return "redirect:/admin/adminSortFirst_findAll";
    }



    // admin 的二级分类的管理
    @GetMapping("/adminSortSecond_findAllByPage")
    public String adminSortSecond_findAllByPage(@RequestParam(name = "page",required = false,defaultValue = "1") int page,Model model,HttpServletRequest request) {

        PageBean<SortSecond> csPageBean = sortSecondService.adminSortSecond_findAllByPage(page);
        HttpSession session = request.getSession();
        session.setAttribute("csPageBean",csPageBean);

        return "redirect:/adminjsp/sortsecond/list.jsp";
    }
    @GetMapping("/adminSortSecond_addPage")
    public String adminSortSecond_addPage(Model model,HttpServletRequest request) throws Exception{

        List<SortFirst> sortFirstList = sortFirstService.findSortFirst();
        HttpSession session = request.getSession();
        session.setAttribute("sortFirstList",sortFirstList);

        return "redirect:/adminjsp/sortsecond/add.jsp";
    }
    @GetMapping("/adminSortSecond_save")
    public String adminSortSecond_save(@RequestParam(name = "sortsecond_name",required = false) String sortsecond_name,@RequestParam(name = "sortfirst_id",required = false) int sortfirst_id,HttpServletRequest request) throws Exception{

        SortSecond sortSecond = new SortSecond();
        sortSecond.setSortsecond_name(sortsecond_name);
        sortSecond.setSortsecond_sortfid(sortfirst_id);
        sortSecondService.adminSortSecond_save(sortSecond);
        return "redirect:/admin/adminSortSecond_findAllByPage";
    }


    @GetMapping("/adminSortSecond_edit")
    public String adminSortSecond_edit(@RequestParam(name = "sortsecond_id",required = false) int sortsecond_id,Model model,HttpServletRequest request) throws Exception{

        SortSecond findByCsid = sortSecondService.findByCsid(sortsecond_id);
        HttpSession session = request.getSession();
        session.setAttribute("findByCsid",findByCsid);

        return "redirect:/adminjsp/sortsecond/edit.jsp";
    }


    @GetMapping("/adminSortSecond_update")
    public String adminSortSecond_update(@RequestParam(name = "sortsecond_name",required = false) String sortsecond_name,@RequestParam(name = "sortsecond_id",required = false) int sortsecond_id,HttpServletRequest request){
        SortSecond sortSecond = new SortSecond();
        sortSecond.setSortsecond_name(sortsecond_name);
        sortSecond.setSortsecond_id(sortsecond_id);
        sortSecondService.adminSortSecond_update(sortSecond);
        return "redirect:/admin/adminSortSecond_findAllByPage?page=1";
    }


    @GetMapping("/adminSortSecond_delete")
    public String adminSortSecond_delete(@RequestParam(name = "sortsecond_id",required = false) int sortsecond_id,HttpServletRequest request) throws Exception{
        sortSecondService.adminSortSecond_delete(sortsecond_id);
        return "redirect:/admin/adminSortSecond_findAllByPage?page=1";
    }

    //admin的商品管理
    @GetMapping("/adminProduct_findAllByPage")
    public String adminProduct_findAllByPage(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Model model,HttpServletRequest request)
            throws Exception {

        PageBean<Product> allProPageBean = productService.findAllProduct(page);
        HttpSession session = request.getSession();
        session.setAttribute("allProPageBean", allProPageBean);
        return "redirect:/adminjsp/product/list.jsp";
    }

    @GetMapping("/adminProduct_addPage")
    public String adminProduct_addPage(Model model,HttpServletRequest request) throws Exception {

        //查询出所有的二级分类
        List<SortSecond> sortSecondList = sortSecondService.findSortSecond();
        HttpSession session = request.getSession();
        session.setAttribute("sortSecondList",sortSecondList);

        return "redirect:/adminjsp/product/add.jsp";
    }

    @RequestMapping("/adminProduct_save")
    public String adminProduct_save(Product product, @RequestParam(name = "sortsecond_id",required = false) int sortsecond_id,HttpServletRequest request,@RequestParam(name = "file",required = false) MultipartFile file) throws Exception {

        String product_name = product.getProduct_name();
        double product_originalprice = product.getProduct_originalprice();
        double product_specialprice = product.getProduct_specialprice();
        int product_popular = product.getProduct_popular();

        Product product1 = new Product();
//		上传图片

        String path = request.getServletContext().getRealPath(
                "/products");
        String uploadFileName = file.getOriginalFilename();
        System.out.println(uploadFileName);
        String fileName = uploadFileName;
        //文件存放路径。现在存在本地，之后可以存在数据库中  路径的最后别忘了加两个\\ 如果不加，字符串拼接会拼到父目录里面去
        //String filePath = "/Users/shaojiahui/Downloads/maven-yy/supershopping/web/products\\";
        File dest = new File("products//"+fileName);
        if (!dest.exists())
            dest.mkdirs();
        if (!file.isEmpty()){
            try {
                file.transferTo(dest);
                product1.setProduct_image("products/" + fileName);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



        System.out.println(product.getProduct_image());
        product1.setProduct_name(product_name);
        product1.setProduct_originalprice(product_originalprice);
        product1.setProduct_specialprice(product_specialprice);
        product1.setProduct_popular(product_popular);
        product1.setProduct_sort(sortsecond_id);

        productService.adminProduct_save(product1);
        return "redirect:/admin/adminProduct_findAllByPage?page=1";
    }

    @GetMapping("/adminProduct_deletecs")
    public String adminProduct_deletecs(@RequestParam int product_id,HttpServletRequest request) throws Exception{

        productService.adminProduct_deletecs(product_id);
        return "redirect:/admin/adminProduct_findAllByPage?page=1";
    }

    @GetMapping("/adminProduct_edit")
    public String adminProduct_edit(@RequestParam int product_id,Model model,HttpServletRequest request) throws Exception{

        Product findProductByPid = productService.findProductByPid(product_id);
        HttpSession session1 = request.getSession();
        session1.setAttribute("findProductByPid",findProductByPid);

        //查询出所有的二级分类
        List<SortSecond> sortSecondList = sortSecondService.findSortSecond();
        HttpSession session = request.getSession();
        session.setAttribute("sortSecondList",sortSecondList);
        return "redirect:/adminjsp/product/edit.jsp";
    }

    @RequestMapping("/adminProduct_update")
    public String adminProduct_update(Product product,HttpServletRequest request,@RequestParam(name = "file",required = false) MultipartFile file) throws Exception {


//		上传图片
//        if (file != null) {
//            String path = request.getServletContext().getRealPath(
//                    "/products");
//            String uploadFileName = file.getOriginalFilename();
//            String fileName = UUIDUtiils.getUUID()+uploadFileName;
//            File diskFile = new File(path + "//" + fileName);
//            file.transferTo(diskFile);
//            product.setProduct_image("products/" + fileName);
//        }

        String path = request.getServletContext().getRealPath(
                "/products");
        String uploadFileName = file.getOriginalFilename();
        System.out.println(uploadFileName);
        String fileName = uploadFileName;
        //文件存放路径。现在存在本地，之后可以存在数据库中  路径的最后别忘了加两个\\ 如果不加，字符串拼接会拼到父目录里面去
        //String filePath = "/Users/shaojiahui/Downloads/maven-yy/supershopping/web/products\\";
        File dest = new File("products//"+fileName);
        if (!dest.exists())
            dest.mkdirs();
        if (!file.isEmpty()){
            try {
                file.transferTo(dest);
                product.setProduct_image("products/" + fileName);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        productService.adminProduct_update(product);
        return "redirect:/admin/adminProduct_findAllByPage?page=1";
    }

}
