package jmu.ssc.supershopping.controller;

import jmu.ssc.supershopping.Utils.PageBean;
import jmu.ssc.supershopping.pojo.Product;
import jmu.ssc.supershopping.service.ProductService;
import jmu.ssc.supershopping.service.SortFirstService;
import jmu.ssc.supershopping.service.SortSecondService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SortFirstController {

    @Resource
    private SortFirstService sortFirstService;

    //查询一级目录下的商品
    @RequestMapping("/findSortFirst")
    public String findSortFirst(HttpServletRequest request, @RequestParam int sortfirst_id, Model model, @RequestParam int page) throws Exception {
        request.getSession().setAttribute("sortfirst_id",sortfirst_id);
        PageBean<Product> proPageBean = sortFirstService.findProductBySortfirst_id(sortfirst_id,page);
        model.addAttribute("pageBean",proPageBean);
        return "sortFirst";
    }



}
