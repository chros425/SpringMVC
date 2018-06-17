package vvr.ssm.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义统一异常处理器
 * 该异常处理器在系统中只能出现一个，和异常类不一样
 * 该异常处理器类还需要在配置文件中定义
 * @author wwr
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	/**
	 * 前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常，
	 * 就会执行该方法。
	 * handler最终要执行的handler，真是身份是HandlerMethod
	 * ex接收到的异常信息
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		//打印出异常
		ex.printStackTrace();
		
		//统一异常处理代码
		
		//异常信息
		String messgae = null;
		
		CustomException customException = null;
		
		//针对系统自定义的CustomException异常，可以直接从该异常类中获取异常信息，并展示在错误页面
		//如果ex是系统自定义异常，直接获取异常信息,即程序员手动抛出的
		if(ex instanceof CustomException) {
			customException = (CustomException) ex;
		}else {
			//针对非CustomException异常（比如运行时异常），则重新构造一个CustomException，错误信息为“未知错误”
			customException = new CustomException("未知错误！");
		}
		//获取错误信息
		messgae = customException.getMessage();
		
		//异常信息存至request域中
		request.setAttribute("messgae", messgae);
		
		try {
			//跳转至错误页面
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
