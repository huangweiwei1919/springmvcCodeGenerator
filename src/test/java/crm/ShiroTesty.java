/*
 * 文件名：ShiroTesty.java	 
 * 时     间：上午9:29:35
 * 作     者：hww      
 */
package crm;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/** 
 * @ClassName: ShiroTesty 
 * @描述: (这里用一句话描述这个类的作用) 
 * @author hww
 * @date 2017年4月6日 上午9:29:35 
 */
public class ShiroTesty {
	public static void main(String[] args) {
		final String remote_url = "http://192.168.1.160:8080/saas/socialactivity/";// 第三方服务器请求地址
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		String result = "";
		try {
			
			
			HttpGet httpGet = new HttpGet(remote_url);
			httpGet.addHeader("Cookie", "sid=4759b8b6-ffa1-4357-8ad8-be6d32e06587");
			HttpResponse response = httpClient.execute(httpGet);// 执行提交
			
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				// 将响应内容转换为字符串
				result = EntityUtils.toString(responseEntity);
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
