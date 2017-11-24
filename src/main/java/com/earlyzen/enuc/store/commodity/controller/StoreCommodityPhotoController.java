package com.earlyzen.enuc.store.commodity.controller;

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
import com.earlyzen.enuc.store.commodity.service.IStoreCommodityPhotoService;
import com.earlyzen.enuc.store.commodity.model.StoreCommodityPhoto;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @Description: 商品照片
 * @author: hww
 * @date: 2017-04-08 11:13:53
 */
@Controller
@Api(description="商品照片", value = "StoreCommodityPhotoController")
@RequestMapping(value="/storecommodityphoto",produces={MediaType.APPLICATION_JSON_VALUE})
public class StoreCommodityPhotoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IStoreCommodityPhotoService iStoreCommodityPhotoservice;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加对象", httpMethod = "POST", 
		response = ApiResult.class, notes = "添加对象",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<StoreCommodityPhoto> addSave(@ModelAttribute("storeCommodityPhoto") StoreCommodityPhoto storeCommodityPhoto) {
		iStoreCommodityPhotoservice.insertSelective(storeCommodityPhoto);
		return new ApiResult<StoreCommodityPhoto>();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces={"application/json;charset=utf-8"})
	@ResponseBody
	@ApiOperation(value = "根据id删除对象，多个id以逗号分隔", httpMethod = "DELETE", 
		response = ApiResult.class, notes = "根据id删除对象，多个id以逗号分隔",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<StoreCommodityPhoto> deleteById(@ApiParam(required = true, name = "id", value = "id主键") @PathVariable String id,
			HttpServletRequest request) {
		if(id.contains(",")){
			iStoreCommodityPhotoservice.deleteBatch(id.split(","));
		}else{
			iStoreCommodityPhotoservice.deleteByPrimaryKey(id);
		}
		return new ApiResult<StoreCommodityPhoto>();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "根据id修改对象", httpMethod = "PUT", 
		response = ApiResult.class, notes = "根据id修改对象",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<StoreCommodityPhoto> updateSave(@ModelAttribute("storeCommodityPhoto") StoreCommodityPhoto storeCommodityPhoto) {
		iStoreCommodityPhotoservice.updateByPrimaryKeySelective(storeCommodityPhoto);
		return new ApiResult<StoreCommodityPhoto>();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取对象", httpMethod = "GET", 
		response = ApiResult.class, notes = "根据id获取对象",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResult<StoreCommodityPhoto> findById(
			@ApiParam(required = true, name = "id", value = "id主键") @PathVariable String id,
			HttpServletRequest request) {
		StoreCommodityPhoto storeCommodityPhoto = iStoreCommodityPhotoservice.selectByPrimaryKey(id);
		ApiResult<StoreCommodityPhoto> result = new ApiResult<StoreCommodityPhoto>();
		result.setData(storeCommodityPhoto);
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
		//2、iStoreCommodityPhotoservice.list(queryJson)查询数据（SQL不需要添加limit参数）
		return PageUtil.getPageResultMap(iStoreCommodityPhotoservice.list(queryJson));
	}
	
}
