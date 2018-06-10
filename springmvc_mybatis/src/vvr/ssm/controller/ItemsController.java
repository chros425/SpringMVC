package vvr.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vvr.ssm.pojo.ItemsCustom;
import vvr.ssm.pojo.ItemsQueryVo;
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
	
	/**
	 * 使用@ModelAttribute将公用的数据的方法返回值传到页面，不用在每一个controller方法通过Model将数据传到页面。
	 * 不需要写url映射
	 * 在前台界面中用到了itemsType时就会显示出数据
	 * 商品类别属于不变的，公用的数据，所以提取出来，可以在多个页面中（多个url或方法中使用）
	 * @return
	 * @throws Exception
	 */
	@ModelAttribute("itemsType")
	public Map<String,String> getItemsType() throws Exception{
		
		HashMap itemsType = new HashMap<String,String>();
		itemsType.put("101", "数码");
		itemsType.put("102","日用品");
		
		return itemsType;
	}
	
	
	/**
	 * 查询所以商品
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * @param model作用是将数据填充到request域，显示到界面
	 * @param id对应商品的id，需要与界面中指定的参数名相同才能完成参数绑定，如果不同，就使用@requestParam注解
	 * @return
	 * @throws Exception
	 * 方法返回字符串，字符串就是指定的逻辑视图名，返回的指定jsp页面
	 */
	@RequestMapping(value = "/editItem",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItem(Model model,Integer id) throws Exception{
		
		
		ItemsCustom itemsCustom = itemsService.findItemById(id);
		
		model.addAttribute("item", itemsCustom);
		
		//return "editItem_2";
		return "editItem";
	}
	
	/**
	 *  没有返回值得方式，当需要向前端返回json数据时，常用这种方式
	 * @param request
	 * @param response
	 * @param id 点击对应商品的修改时传来的id
	 * @throws Exception
	 */
	/*@RequestMapping(value = "/editItem",method = {RequestMethod.GET,RequestMethod.POST})
	public void editItem(HttpServletRequest request,HttpServletResponse response
			
			,@RequestParam(value="id",required=true,defaultValue="1")Integer id) throws Exception{
		
		ItemsCustom itemsCustom = itemsService.findItemById(id);
		
		request.setAttribute("item", itemsCustom);
		
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
	}*/
	
	/**
	 * 商品修改提交，使用返回字符串的方式，重定向或转发的方式返回action
	 * @param id商品的id
	 * @param itemCustom商品类，里面包含商品的简单数据类型，springmvc会找到该类中相同名称的属性
	 * @param itemsQueryVo包装数据类型，包含多个pojo类型，对应的，前台jsp表单的name属性需要加上对应的属性，例如itemsCustom.name
	 * @param @ModelAttribute(value="item") 中value指定的是key，该注解相当于model.addAttribute("item", itemsCustom);
	 * 		  存到request域中。可以完成数据回显的操作
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/editItemSubmit",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItemSubmit(Integer id,@ModelAttribute(value="item") ItemsCustom itemsCustom
			,ItemsQueryVo itemsQueryVo) throws Exception {
		
		//执行修改
		itemsService.updateItem(id, itemsCustom);
		//itemsService.updateItem(id, itemsQueryVo.getItemsCustom());
		
		//重定向，以为是在同一个根路径下，所以可以不用加根路径
		//return "redirect:queryItems.action";
		
		//跳回到修改界面，查看数据回显
		return "editItem";
		
		//转发
		//return "forward:queryItems.action";
	}
}
