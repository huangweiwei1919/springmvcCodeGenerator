package com.earlyzen.enuc.store.subject.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.subject.model.StoreSubjectContent;

/**
 * @Description: 商品专题内容
 * @author: hww
 * @date: 2017-04-10 21:06:43
 */
public interface IStoreSubjectContentService extends IBaseService<StoreSubjectContent, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreSubjectContent> list(String queryJson);
}
