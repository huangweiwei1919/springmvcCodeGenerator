package com.earlyzen.crm.psauser.service.impl;

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
import com.earlyzen.crm.psauser.dao.mapper.PsaUserMapper;
import com.earlyzen.crm.psauser.model.PsaUser;
import com.earlyzen.crm.psauser.service.IPsaUserService;

/**
 * @Description: psauser测试
 * @author: chenxiaomin
 * @date: 2017-03-17 10:02:57
 */
@Service
public class PsaUserServiceImpl extends BaseServiceImpl<PsaUser, String> implements IPsaUserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PsaUserMapper psaUserMapper;
	
	@Override
	public IBaseMapper<PsaUser, String> getMapper(){
		return psaUserMapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<PsaUser> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return psaUserMapper.list(queryParamMap);
	}

}
