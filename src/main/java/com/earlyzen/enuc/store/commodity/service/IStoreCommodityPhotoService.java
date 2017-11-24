package com.earlyzen.enuc.store.commodity.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityPhoto;

/**
 * @Description: 商品照片
 * @author: hww
 * @date: 2017-04-08 11:13:53
 */
public interface IStoreCommodityPhotoService extends IBaseService<StoreCommodityPhoto, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<StoreCommodityPhoto> list(String queryJson);
}
