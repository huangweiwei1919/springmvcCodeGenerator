package ##{srcPack}##.service;

import java.util.List;
import com.earlyzen.core.base.service.IBaseService;
import ##{srcPack}##.model.##{domainObjectName}##;

/**
 * @Description: ##{description}##
 * @author: ##{author}##
 * @date: ##{date}##
 */
public interface I##{domainObjectName}##Service extends IBaseService<##{domainObjectName}##, String> {
	
	/**
	 * 查询列表
	 * @param queryJson
	 * @return
	 * @return List<PsaUser>
	 */
	List<##{domainObjectName}##> list(String queryJson);
}
