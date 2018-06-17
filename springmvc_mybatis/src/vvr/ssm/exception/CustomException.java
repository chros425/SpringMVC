package vvr.ssm.exception;

/**
 * 自定义异常类，异常类型通常继承于Exception。实际开发中可能需要定义许多自定义异常类
 * 该类的作用就是让程序员对于已知的错误，抛到这个类中，再由异常处理器去解决显示。
 * 对于未知的，比如运行时异常，通过异常处理器来转成该异常类，接收到异常信息，显示到界面中给用户看。
 * @author wwr
 *
 */
public class CustomException extends Exception {

	//异常信息
	private String message;
	
	public CustomException(String message) {
		
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
