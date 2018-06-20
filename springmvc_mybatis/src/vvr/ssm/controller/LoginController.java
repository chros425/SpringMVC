package vvr.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * 登录
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) throws Exception{
		
		//调用service层对用户进行验证，数据库中是否存在
		//....
		
		session.setAttribute("username", username);
		
		//重定向到商品查询页面
		return "redirect:/items/queryItems.action";
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) throws Exception{
		
		//销毁session
		session.invalidate();
		
		//重定向到商品查询页面
		return "redirect:/items/queryItems.action";
	}
}
