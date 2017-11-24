package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityParameter;

/**
 * @Description: 商品参数
 * @author: hww
 * @date: 2017-04-08 11:12:12
 */
public interface IStoreCommodityParameterService extends IBaseService<StoreCommodityParameter, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreCommodityParameter> list(String queryJson);
}
