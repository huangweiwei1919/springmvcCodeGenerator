package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreCommodity;

/**
 * @Description: 商品
 * @author: hww
 * @date: 2017-04-08 11:08:25
 */
public interface IStoreCommodityService extends IBaseService<StoreCommodity, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreCommodity> list(String queryJson);
}
