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
import com.earlyzen.enuc.socail.attention.dao.mapper.SocialShareUserMapper;
import com.earlyzen.enuc.socail.attention.model.SocialShareUser;
import com.earlyzen.enuc.socail.attention.service.ISocialShareUserService;

/**
 * @Description: 用户分享信息总览
 * @author: hww
 * @date: 2017-04-06 11:58:35
 */
@Service
public class SocialShareUserServiceImpl extends BaseServiceImpl<SocialShareUser, String> implements ISocialShareUserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SocialShareUserMapper socialShareUserMapper;
	
	@Override
	public IBaseMapper<SocialShareUser, String> getMapper(){
		return socialShareUserMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<SocialShareUser> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return socialShareUserMapper.list(queryParamMap);
	}

}
