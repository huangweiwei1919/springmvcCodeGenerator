package com.earlyzen.enuc.store.subject.service.impl;

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
import com.earlyzen.enuc.store.subject.dao.mapper.StoreSubjectCommodityMapper;
import com.earlyzen.enuc.store.subject.model.StoreSubjectCommodity;
import com.earlyzen.enuc.store.subject.service.IStoreSubjectCommodityService;

/**
 * @Description: 商品专题商品
 * @author: hww
 * @date: 2017-04-10 21:05:47
 */
@Service
public class StoreSubjectCommodityServiceImpl extends BaseServiceImpl<StoreSubjectCommodity, String> implements IStoreSubjectCommodityService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreSubjectCommodityMapper storeSubjectCommodityMapper;
	
	@Override
	public IBaseMapper<StoreSubjectCommodity, String> getMapper(){
		return storeSubjectCommodityMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreSubjectCommodity> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeSubjectCommodityMapper.list(queryParamMap);
	}

}
