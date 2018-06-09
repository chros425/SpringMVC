package vvr.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 字符串转日期类型
 * springmvc本身没有对日期类型参数做处理，需要程序员自己解决，指定时间显示格式
 * @author wwr
 *
 */
public class CustomerDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		try {
			
			//将指定字符串转成日期格式，还需要在配置文件中配置该类
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
