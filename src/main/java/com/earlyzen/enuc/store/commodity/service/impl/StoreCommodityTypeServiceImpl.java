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
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreCommodityTypeMapper;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityType;
import com.earlyzen.enuc.store.commodity.service.IStoreCommodityTypeService;

/**
 * @Description: 商品分类
 * @author: hww
 * @date: 2017-04-08 11:26:11
 */
@Service
public class StoreCommodityTypeServiceImpl extends BaseServiceImpl<StoreCommodityType, String> implements IStoreCommodityTypeService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreCommodityTypeMapper storeCommodityTypeMapper;
	
	@Override
	public IBaseMapper<StoreCommodityType, String> getMapper(){
		return storeCommodityTypeMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreCommodityType> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeCommodityTypeMapper.list(queryParamMap);
	}

}
