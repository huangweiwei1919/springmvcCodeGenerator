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
import com.earlyzen.enuc.store.subject.dao.mapper.StoreSubjectContentMapper;
import com.earlyzen.enuc.store.subject.model.StoreSubjectContent;
import com.earlyzen.enuc.store.subject.service.IStoreSubjectContentService;

/**
 * @Description: 商品专题内容
 * @author: hww
 * @date: 2017-04-10 21:06:43
 */
@Service
public class StoreSubjectContentServiceImpl extends BaseServiceImpl<StoreSubjectContent, String> implements IStoreSubjectContentService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreSubjectContentMapper storeSubjectContentMapper;
	
	@Override
	public IBaseMapper<StoreSubjectContent, String> getMapper(){
		return storeSubjectContentMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<StoreSubjectContent> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return storeSubjectContentMapper.list(queryParamMap);
	}

}
