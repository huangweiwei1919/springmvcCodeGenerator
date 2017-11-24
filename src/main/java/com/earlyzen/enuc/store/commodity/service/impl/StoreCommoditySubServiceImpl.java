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
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreCommoditySubMapper;
import com.earlyzen.enuc.store.commodity.model.StoreCommoditySub;
import com.earlyzen.enuc.store.commodity.service.IStoreCommoditySubService;

/**
 * @Description: 商品子类
 * @author: hww
 * @date: 2017-04-08 11:15:43
 */
@Service
public class StoreCommoditySubServiceImpl extends BaseServiceImpl<StoreCommoditySub, String> implements IStoreCommoditySubService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreCommoditySubMapper storeCommoditySubMapper;
	
	@Override
	public IBaseMapper<StoreCommoditySub, String> getMapper(){
		return storeCommoditySubMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreCommoditySub> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeCommoditySubMapper.list(queryParamMap);
	}

}
