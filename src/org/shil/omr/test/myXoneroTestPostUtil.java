package org.shil.omr.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class myXoneroTestPostUtil {
	
	public static void main(String[] args){
		testPostUrl();
	}
	//my mo ne ro
	public static String testPostUrl() {
		
		String responseBody = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	HttpPost httppost = new HttpPost("https://api.myxxx.com:8443/get_address_txs");
//        	HttpPost httppost = new HttpPost("https://api.myxxx.com:8443/get_address_info");
        	httppost.addHeader("Accept","application/json, text/plain, */*");
        	httppost.addHeader("Accept-Encoding","gzip, deflate, br");
        	httppost.addHeader("Accept-Language","en-US, en; q=0.8");
        	httppost.addHeader("Cache-Control","no-cache");
        	httppost.addHeader("Content-Type","application/json; charset=utf-8");
        	httppost.addHeader("Host","api.myxxx.com:8443");
        	httppost.addHeader("Origin","https://myxxx.com");
        	httppost.addHeader("Referer","https://myxxx.com/");
        	httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299");
        	
        	JSONObject jsonParam = new JSONObject();  
//        	jsonParam.put("address", "44S6ZgwJJYwA6kgQryMnWbZyjj3YDsP4Y9bK3PDzoHse9wKY4dAEKFkCJZE6rPhyoBGsWAf7VEa9KDjwqAVLR2JVDY3VNT1");
//        	jsonParam.put("view_key", "af61266716d1cb10340d5f772fd32524d99be1bcdea9bf15f7d56d7241d2fe0e");

        	jsonParam.put("address", "432BJLChHY3VnCwapspsgq5PuYjwmrgkrSXjhX1mbz9gXZPDm5X3vRjRZHapV9ARCShZJzCJM9HFtSiGtAMTQf9Q5VBZUgF");
        	jsonParam.put("view_key", "09a2c6e61dbf4c636eeaf8a68ff179481f58f00a9ff9df4b1a04af9898e21c0c");
        	
        	StringEntity entity = new StringEntity(jsonParam.toJSONString()); 
        	httppost.setEntity(entity);
        	
        	HttpResponse resp = httpclient.execute(httppost);
        	System.out.println("response code:"+resp.getStatusLine().getStatusCode());
//        	System.out.println(resp.toString());
        	HttpEntity he = resp.getEntity();
        	responseBody = EntityUtils.toString(he,"UTF-8");
        	System.out.println(responseBody);
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        finally {
            try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        return responseBody;
	}
}
