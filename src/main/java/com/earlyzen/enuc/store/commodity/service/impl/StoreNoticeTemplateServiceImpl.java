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
import com.earlyzen.enuc.store.commodity.dao.mapper.StoreNoticeTemplateMapper;
import com.earlyzen.enuc.store.commodity.model.StoreNoticeTemplate;
import com.earlyzen.enuc.store.commodity.service.IStoreNoticeTemplateService;

/**
 * @Description: 商品须知模板
 * @author: hww
 * @date: 2017-04-10 20:05:18
 */
@Service
public class StoreNoticeTemplateServiceImpl extends BaseServiceImpl<StoreNoticeTemplate, String> implements IStoreNoticeTemplateService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreNoticeTemplateMapper storeNoticeTemplateMapper;
	
	@Override
	public IBaseMapper<StoreNoticeTemplate, String> getMapper(){
		return storeNoticeTemplateMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreNoticeTemplate> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeNoticeTemplateMapper.list(queryParamMap);
	}

}
