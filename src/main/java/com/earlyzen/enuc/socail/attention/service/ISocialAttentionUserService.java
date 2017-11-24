package com.earlyzen.enuc.socail.attention.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import com.earlyzen.enuc.socail.attention.model.SocialAttentionUser;

/**
 * @Description: 用户关注
 * @author: hww
 * @date: 2017-04-06 11:59:21
 */
public interface ISocialAttentionUserService extends IBaseService<SocialAttentionUser, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<SocialAttentionUser> list(String queryJson);
}
