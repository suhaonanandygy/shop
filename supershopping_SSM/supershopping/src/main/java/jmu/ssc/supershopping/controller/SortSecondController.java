package jmu.ssc.supershopping.controller;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.service.ProductService;
import jmu.ssc.supershopping.service.SortSecondService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SortSecondController {
    @Resource
    private SortSecondService sortSecondService;

    @RequestMapping("/findSortSecond")
    //查询二级分类下的商品
    public String findSortFirst(HttpServletRequest request, @RequestParam int csid, Model model, @RequestParam int page) throws Exception {
        request.getSession().setAttribute("csid",csid);
        PageBean<Product> proPageBean = sortSecondService.findProductBysortsecond_id(csid,page);
        model.addAttribute("pageBean",proPageBean);
        return "sortFirst";
    }
}
