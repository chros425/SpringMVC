package vvr.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;
/**
 * 字符串去除空格转换器
 * @author wwr
 *
 */
public class StringTrimConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {
		
		if(source != null) {
			source = source.trim();
			if(source == "") {
				return null;
			}
		}
		
		return source;
	}

}
