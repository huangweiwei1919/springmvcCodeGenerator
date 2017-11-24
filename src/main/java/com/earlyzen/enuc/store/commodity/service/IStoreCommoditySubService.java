package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreCommoditySub;

/**
 * @Description: 商品子类
 * @author: hww
 * @date: 2017-04-08 11:15:43
 */
public interface IStoreCommoditySubService extends IBaseService<StoreCommoditySub, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreCommoditySub> list(String queryJson);
}
