package vvr.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vvr.ssm.pojo.ItemsCustom;

/**
 * json数据测试
 * @author wwr
 *
 */
@Controller
public class JsonTest {

	/**
	 * 请求json，响应json，请求商品信息json数据，响应商品信息json数据
	 * @param itemsCustom
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/requestJson.action")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception{
		
		
		return itemsCustom;
	}
	
	/**
	 * 请求key/value，响应json
	 * @param itemsCustom
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/responseJson.action")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception{
		
		
		return itemsCustom;
	}
}
