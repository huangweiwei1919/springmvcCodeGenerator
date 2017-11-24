package com.earlyzen.enuc.store.commodity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.earlyzen.core.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import com.earlyzen.core.base.mapper.IBaseMapper;
import com.earlyzen.core.base.service.impl.BaseServiceImpl;
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreCommodityPhotoMapper;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityPhoto;
import com.earlyzen.enuc.store.commodity.service.IStoreCommodityPhotoService;

/**
 * @Description: 商品照片
 * @author: hww
 * @date: 2017-04-08 11:13:53
 */
@Service
public class StoreCommodityPhotoServiceImpl extends BaseServiceImpl<StoreCommodityPhoto, String> implements IStoreCommodityPhotoService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreCommodityPhotoMapper storeCommodityPhotoMapper;
	
	@Override
	public IBaseMapper<StoreCommodityPhoto, String> getMapper(){
		return storeCommodityPhotoMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreCommodityPhoto> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeCommodityPhotoMapper.list(queryParamMap);
	}

}
