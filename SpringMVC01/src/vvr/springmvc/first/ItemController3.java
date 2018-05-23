package vvr.springmvc.first;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import vvr.springmvc.pojo.Items;

/**
 * 使用注解方式开发，不需要实现接口
 * @author wwr
 *
 */

@Controller
public class ItemController3 {

	//商品列表，@RequestMapping中的url建议与方法名相同
	//这里的url地址后可以不加.action,也可以加，但是，如果不加，在浏览器访问时需要加上
	@RequestMapping("/itemsList123.action")
	public ModelAndView itemsList() {
		
		// 商品列表
		List<Items> itemsList = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("联想笔记本a");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone5  苹果手机！");
		

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		
		//指定跳转的视图界面
		modelAndView.setViewName("itemsList");
		
		return modelAndView;

	}

}
