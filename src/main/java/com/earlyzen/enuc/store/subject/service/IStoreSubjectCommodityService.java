package com.earlyzen.enuc.store.subject.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.subject.model.StoreSubjectCommodity;

/**
 * @Description: 商品专题商品
 * @author: hww
 * @date: 2017-04-10 21:05:47
 */
public interface IStoreSubjectCommodityService extends IBaseService<StoreSubjectCommodity, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreSubjectCommodity> list(String queryJson);
}
