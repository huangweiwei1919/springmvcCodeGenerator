package com.earlyzen.enuc.socail.attention.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.socail.attention.model.SocialShareUser;

/**
 * @Description: 用户分享信息总览
 * @author: hww
 * @date: 2017-04-06 11:58:35
 */
public interface ISocialShareUserService extends IBaseService<SocialShareUser, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<SocialShareUser> list(String queryJson);
}
