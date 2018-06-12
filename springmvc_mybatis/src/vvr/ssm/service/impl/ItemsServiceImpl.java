package vvr.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import vvr.ssm.mapper.ItemsMapper;
import vvr.ssm.mapper.ItemsMapperCustom;
import vvr.ssm.pojo.Items;
import vvr.ssm.pojo.ItemsCustom;
import vvr.ssm.pojo.ItemsQueryVo;
import vvr.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	//需要注入dao，使用注解注入，还需要在spring配置文件中配置service
	//因为dao是通过扫描mapper代理生成，所有没有在配置文件中定义相应的bean
	//所以配置service时，没法使用property注入，所以采用注解注入
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemById(Integer id) throws Exception {
		
		//根据id查询出商品信息
		Items item = itemsMapper.selectByPrimaryKey(id);
		
		//由于返回的是扩展类，而且随着需求的变更，如果想要获得商品的其他信息，就会需要使用扩展类
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性拷贝到itemCustomer中
		BeanUtils.copyProperties(item, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception {

		//对于关键数据的非空校验
		if(id == null) {
			// 抛出异常，提示调用接口的用户
		}
		
		//不能修改大文本数据
		//itemsMapper.updateByPrimaryKey(itemsCustom);
		
		//可以修改大文本数据
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public void deleteItem(Integer[] id) throws Exception {
		
		if(id == null) {
			//抛出异常
		}
		
		itemsMapperCustom.batchDeleteById(id);
	}

}
