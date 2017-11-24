package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreNoticeTemplate;

/**
 * @Description: 商品须知模板
 * @author: hww
 * @date: 2017-04-10 20:05:18
 */
public interface IStoreNoticeTemplateService extends IBaseService<StoreNoticeTemplate, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreNoticeTemplate> list(String queryJson);
}
