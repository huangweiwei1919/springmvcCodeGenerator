package com.earlyzen.crm.common;

import java.util.Map;

import com.earlyzen.core.util.ResourceUtil;

/**
 * @Description 配置信息类
 * @author chenxiaomin
 * @date 2017年01月18日 下午2:49:50
 */
public class Config {
	
	//服务器地址
	public static final String crmServer;

	//附件
	public static final String filePreviewUrl, fileUploadUrl;
	
	static{
		Map<String, String> properties = ResourceUtil.getPropertie("init.properties");
		crmServer = properties.get("crm.server");
		filePreviewUrl = properties.get("file.previewUrl");
		fileUploadUrl = properties.get("file.uploadUrl");
	}
	
}
