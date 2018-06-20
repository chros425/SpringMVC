package vvr.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器使用的AOP
 * @author wwr
 *
 */
public class LoginInteceptor implements HandlerInterceptor {

	@Override
	/**
	 * 在执行handler后执行该方法
	 * 做系统统一异常处理
	 * 进行方法性能监控
	 * 实现系统统一日志
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	/**
	 * 在执行preHandle时，返回modelandview之前执行
	 * 如果需要向页面提供一些公用的数据或配置一些视图信息，使用此方法实现modelAndView
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	/**
	 * 在执行handler之前执行
	 * 用于用户校验验证
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//得到url请求
		String url = request.getRequestURI();
		
		//判断地址是否公开
		//判断url中包含login.action的位置
		if(url.indexOf("login.action") >= 0) {
			
			//如果是公开地址，放行
			return true;
		}
		
		HttpSession session = request.getSession();
		//获取session中的用户名
		String username = (String) session.getAttribute("username");
		
		//如果用户名存在，放行
		if(username != null) {
			return true;
		}
		
		//执行到这里进行拦截，跳转到用户登录界面，进行身份验证
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		
		//返回false不放行，返回true时放行
		return false;
	}

}
