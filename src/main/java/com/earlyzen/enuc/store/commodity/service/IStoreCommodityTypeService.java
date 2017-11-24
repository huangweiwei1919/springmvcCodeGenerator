package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityType;

/**
 * @Description: 商品分类
 * @author: hww
 * @date: 2017-04-08 11:26:11
 */
public interface IStoreCommodityTypeService extends IBaseService<StoreCommodityType, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreCommodityType> list(String queryJson);
}
