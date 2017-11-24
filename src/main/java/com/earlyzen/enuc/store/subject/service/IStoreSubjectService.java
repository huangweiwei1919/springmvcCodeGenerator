package com.earlyzen.enuc.store.subject.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.subject.model.StoreSubject;

/**
 * @Description: 商品专题
 * @author: hww
 * @date: 2017-04-10 20:36:31
 */
public interface IStoreSubjectService extends IBaseService<StoreSubject, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreSubject> list(String queryJson);
}
