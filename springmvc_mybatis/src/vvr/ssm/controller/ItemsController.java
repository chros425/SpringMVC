package vvr.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vvr.ssm.pojo.ItemsCustom;
import vvr.ssm.service.ItemsService;

/**
 * 商品管理控制层
 * @author wwr
 *
 */
@Controller
//定义url的根路径，访问时使用根路径+方法的url
@RequestMapping("/items")
public class ItemsController {
	
	//注入service，同样使用注解
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		modelAndView.addObject("itemsList", itemsList);
		
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
	}
	
	/**
	 * 显示指定id的商品信息
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value = "/editItem",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView editItem() throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		
		ItemsCustom itemsCustom = itemsService.findItemById(1);
		modelAndView.addObject("item",itemsCustom);
		
		modelAndView.setViewName("editItem");
		
		return modelAndView;
	}*/
	
	//方法返回字符串，返回的代表jsp页面
	//model作用是将数据填充到request域，显示到界面
	/*@RequestMapping(value = "/editItem",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItem(Model model) throws Exception{
		
		
		ItemsCustom itemsCustom = itemsService.findItemById(1);
		
		model.addAttribute("item", itemsCustom);
		
		return "editItem";
		
	}*/
	
	
	@RequestMapping(value = "/editItem",method = {RequestMethod.GET,RequestMethod.POST})
	public void editItem(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ItemsCustom itemsCustom = itemsService.findItemById(1);
		
		request.setAttribute("item", itemsCustom);
		
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
	}
	
	/**
	 * 商品修改提交
	 * @return
	 */
	@RequestMapping(value = "/editItemSubmit",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItemSubmit() {
		
		//重定向，以为是在同一个根路径下，所以可以不用加根路径
		return "redirect:queryItems.action";
		
		//转发
		//return "forword://queryItems.action";
	}
}
