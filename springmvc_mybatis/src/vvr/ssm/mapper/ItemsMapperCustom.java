package vvr.ssm.mapper;

import java.util.List;

import vvr.ssm.pojo.ItemsCustom;
import vvr.ssm.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {

	//查询商品
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
