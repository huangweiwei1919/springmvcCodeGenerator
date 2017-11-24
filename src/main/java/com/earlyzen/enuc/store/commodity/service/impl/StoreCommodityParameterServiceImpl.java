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
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreCommodityParameterMapper;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityParameter;
import com.earlyzen.enuc.store.commodity.service.IStoreCommodityParameterService;

/**
 * @Description: 商品参数
 * @author: hww
 * @date: 2017-04-08 11:12:12
 */
@Service
public class StoreCommodityParameterServiceImpl extends BaseServiceImpl<StoreCommodityParameter, String> implements IStoreCommodityParameterService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreCommodityParameterMapper storeCommodityParameterMapper;
	
	@Override
	public IBaseMapper<StoreCommodityParameter, String> getMapper(){
		return storeCommodityParameterMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreCommodityParameter> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeCommodityParameterMapper.list(queryParamMap);
	}

}
