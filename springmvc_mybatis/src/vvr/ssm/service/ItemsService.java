package vvr.ssm.service;

import java.util.List;

import vvr.ssm.pojo.ItemsCustom;
import vvr.ssm.pojo.ItemsQueryVo;

public interface ItemsService {

	
	//查询商品
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**
	 * 根据id查询商品信息
	 * @param id为商品的id
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom findItemById(Integer id) throws Exception;
	
	/**
	 *  修改商品信息
	 * @param id商品的id
	 * @param itemsCustom商品的信息
	 * @throws Exception
	 */
	public void updateItem(Integer id,ItemsCustom itemsCustom) throws Exception;
}
