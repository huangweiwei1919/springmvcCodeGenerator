package com.earlyzen.enuc.socail.attention.service.impl;

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
import com.earlyzen.enuc.socail.attention.dao.mapper.SocialAttentionUserMapper;
import com.earlyzen.enuc.socail.attention.model.SocialAttentionUser;
import com.earlyzen.enuc.socail.attention.service.ISocialAttentionUserService;

/**
 * @Description: 用户关注
 * @author: hww
 * @date: 2017-04-06 11:59:21
 */
@Service
public class SocialAttentionUserServiceImpl extends BaseServiceImpl<SocialAttentionUser, String> implements ISocialAttentionUserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SocialAttentionUserMapper socialAttentionUserMapper;
	
	@Override
	public IBaseMapper<SocialAttentionUser, String> getMapper(){
		return socialAttentionUserMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<SocialAttentionUser> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return socialAttentionUserMapper.list(queryParamMap);
	}

}
