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
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreCommodityMapper;
import com.earlyzen.enuc.store.commodity.model.StoreCommodity;
import com.earlyzen.enuc.store.commodity.service.IStoreCommodityService;

/**
 * @Description: 商品
 * @author: hww
 * @date: 2017-04-08 11:08:25
 */
@Service
public class StoreCommodityServiceImpl extends BaseServiceImpl<StoreCommodity, String> implements IStoreCommodityService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreCommodityMapper storeCommodityMapper;
	
	@Override
	public IBaseMapper<StoreCommodity, String> getMapper(){
		return storeCommodityMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreCommodity> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeCommodityMapper.list(queryParamMap);
	}

}
