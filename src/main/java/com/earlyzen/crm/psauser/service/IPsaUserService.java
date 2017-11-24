package com.earlyzen.crm.psauser.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.crm.psauser.model.PsaUser;

/**
 * @Description: psauser测试
 * @author: chenxiaomin
 * @date: 2017-03-17 10:02:57
 */
public interface IPsaUserService extends IBaseService<PsaUser, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<PsaUser> list(String queryJson);
}
