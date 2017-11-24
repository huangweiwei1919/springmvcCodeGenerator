package ##{srcPack}##.service.impl;

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
import ##{srcPack}##.dao.mapper.##{domainObjectName}##Mapper;
import ##{srcPack}##.model.##{domainObjectName}##;
import ##{srcPack}##.service.I##{domainObjectName}##Service;

/**
 * @Description: ##{description}##
 * @author: ##{author}##
 * @date: ##{date}##
 */
@Service
public class ##{domainObjectName}##ServiceImpl extends BaseServiceImpl<##{domainObjectName}##, String> implements I##{domainObjectName}##Service{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ##{domainObjectName}##Mapper ##{firstLowerDomainObjectName}##Mapper;
	
	@Override
	public IBaseMapper<##{domainObjectName}##, String> getMapper(){
		return ##{firstLowerDomainObjectName}##Mapper;
	}
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	public List<##{domainObjectName}##> list(String queryJson) {
		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(queryJson)){
			queryParamMap = JsonUtil.json2Map(queryJson);
		}
		return ##{firstLowerDomainObjectName}##Mapper.list(queryParamMap);
	}

}
