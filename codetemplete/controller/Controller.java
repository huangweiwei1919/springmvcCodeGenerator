package ##{srcPack}##.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.earlyzen.core.apiresult.ApiResult;
import com.earlyzen.core.util.PageUtil;
import ##{srcPack}##.service.I##{domainObjectName}##Service;
import ##{srcPack}##.model.##{domainObjectName}##;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @Description: ##{description}##
 * @author: ##{author}##
 * @date: ##{date}##
 */
@Controller
@Api(description="##{description}##--黄伟伟", value = "##{domainObjectName}##Controller")
@RequestMapping(value="/##{requestMappingName}##",produces={MediaType.APPLICATION_JSON_VALUE})
public class ##{domainObjectName}##Controller {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private I##{domainObjectName}##Service i##{domainObjectName}##service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加##{description}##", httpMethod = "POST", 
		response = ApiResult.class, notes = "添加##{description}##",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<##{domainObjectName}##> addSave(@ModelAttribute("##{firstLowerDomainObjectName}##") ##{domainObjectName}## ##{firstLowerDomainObjectName}##) {
		i##{domainObjectName}##service.insertSelective(##{firstLowerDomainObjectName}##);
		return new ApiResult<##{domainObjectName}##>();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces={"application/json;charset=utf-8"})
	@ResponseBody
	@ApiOperation(value = "根据id删除对象，多个id以逗号分隔", httpMethod = "DELETE", 
		response = ApiResult.class, notes = "根据id删除对象，多个id以逗号分隔",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<##{domainObjectName}##> deleteById(@ApiParam(required = true, name = "id", value = "id主键") @PathVariable String id,
			HttpServletRequest request) {
		if(id.contains(",")){
			i##{domainObjectName}##service.deleteBatch(id.split(","));
		}else{
			i##{domainObjectName}##service.deleteByPrimaryKey(id);
		}
		return new ApiResult<##{domainObjectName}##>();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "根据id修改##{description}##", httpMethod = "PUT", 
		response = ApiResult.class, notes = "根据id修改##{description}##",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<##{domainObjectName}##> updateSave(@ModelAttribute("##{firstLowerDomainObjectName}##") ##{domainObjectName}## ##{firstLowerDomainObjectName}##) {
		i##{domainObjectName}##service.updateByPrimaryKeySelective(##{firstLowerDomainObjectName}##);
		return new ApiResult<##{domainObjectName}##>();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取对象", httpMethod = "GET", 
		response = ApiResult.class, notes = "根据id获取对象",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<##{domainObjectName}##> findById(
			@ApiParam(required = true, name = "id", value = "id主键") @PathVariable String id,
			HttpServletRequest request) {
		##{domainObjectName}## ##{firstLowerDomainObjectName}## = i##{domainObjectName}##service.selectByPrimaryKey(id);
		ApiResult<##{domainObjectName}##> result = new ApiResult<##{domainObjectName}##>();
		result.setData(##{firstLowerDomainObjectName}##);
		return result;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询列表", httpMethod = "GET", 
		response = ApiResult.class, notes = "查询列表",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<Map<String, Object>> list(
			@RequestParam(value = "queryJson", required = false, defaultValue = "") String queryJson,
			@RequestParam(value = "pageNum", required = false, defaultValue = "") Integer pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "") Integer pageSize,
			HttpServletRequest request) {
		
		//1、开始分页（下面紧跟着的第一个查询会被分页）
		PageUtil.startPage();
		//2、i##{domainObjectName}##service.list(queryJson)查询数据（SQL不需要添加limit参数）
		return PageUtil.getPageResultMap(i##{domainObjectName}##service.list(queryJson));
	}
	
}
