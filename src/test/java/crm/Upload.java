/*
 * 文件名：Upload.java	 
 * 时     间：下午1:46:01
 * 作     者：hww      
 */
package crm;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName: Upload
 * @描述: (这里用一句话描述这个类的作用)
 * @author hww
 * @date 2017年4月1日 下午1:46:01
 */
public class Upload {
	
	public static void main(String[] args) {
		final String remote_url = "http://192.168.1.160:8080/filestore/fileUpload/uploadImage.json";// 第三方服务器请求地址
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		String result = "";
		try {
			File file = new File("E:\\filestore\\upload\\201703\\29\\1黄.jpg");
			FileBody bin = new FileBody(file);
			
			HttpPost httpPost = new HttpPost(remote_url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.setCharset(Charset.forName("UTF-8"));
			builder.addPart("multipartFile", bin);
			builder.addTextBody("isCompress", "0");
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);// 执行提交
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
