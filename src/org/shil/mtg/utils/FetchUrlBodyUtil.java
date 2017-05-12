package org.shil.mtg.utils;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class FetchUrlBodyUtil {

	public static String stand = "CHSESSION=5p6t7dpdtj03ljtl9oug0v9ts5; visid_incap_839682=Y2evWq9iQ/CnqNS44KGhUwJph1gAAAAAQkIPAAAAAACADgp8AXbBFIqXKAfjUUs6sYsKhlDkdpeE; ajs_user_id=null; ajs_group_id=null; ajs_anonymous_id=%22c3a40103-d7a0-4019-b654-5d22756afa5f%22; _ga=GA1.2.1509432278.1485269260; intercom-id-jv6shdwn=920223f0-e140-4bfe-86a0-052aafec36e2; App[AnonymousId]=Q2FrZQ%3D%3D.pua3hG9eoNdgt6LUv3cW%2FiJsM3uDpdeVzhi8y9J%2B9CIkJE6unwnkHS3HKDnT7LDP55LX4q3qkHwzsRs92SFjqfajGnXW48jTosQWH6cOf7o2Vh5N7t1PSr00Lj%2F3CH5DXnE%3D; _gid=GA1.2.1212319445.1494515852; ";
	
	public static String cookie = "";
	
	public static void main(String[] args){
		System.out.println("111111111111111----->>>--->" + cookie);
		fetchUrlBodyResetCookie("https://www.cardhoarder.com/cards/63668?utm_campaign=affiliate&utm_source=mtggoldfish&utm_medium=card&affiliate_id=mtggoldfish&ref=card,time-to-reflect-akh");
		System.out.println("2222222222222----->>>--->" + cookie);
		fetchUrlBodyResetCookie("https://www.cardhoarder.com/cards/63668?utm_campaign=affiliate&utm_source=mtggoldfish&utm_medium=card&affiliate_id=mtggoldfish&ref=card,time-to-reflect-akh");
	}
	
	public static String fetchUrlBodyResetCookie(String cardurl){
		String responseBody = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	cookie +=stand;
        	HttpGet httpget = new HttpGet(cardurl);
        	httpget.addHeader(new BasicHeader("Cookie",cookie));
        	httpget.addHeader("Accept","text/html, application/xhtml+xml, image/jxr, */*");
        	httpget.addHeader("Accept-Encoding","gzip, deflate");
        	httpget.addHeader("Accept-Language","en-US, en; q=0.8, zh-Hans-CN; q=0.5, zh-Hans; q=0.3");
        	httpget.addHeader("Host","www.cardhoarder.com");
        	httpget.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
        	
//            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    Header[] hs = response.getHeaders("Set-Cookie");
                    cookie = "";
                	for(Header h : hs){
                		cookie += h.getValue()+";";
                		System.out.println(" ================= "+h);
                	}
                	
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response stat0us: " + status);
                    }
                }
            };
            
            responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println("----------------------------------------");
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
	
	public static String fetchUrlBody(String cardurl){
		String responseBody = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	HttpGet httpget = new HttpGet(cardurl);
        	httpget.addHeader(new BasicHeader("Cookie","incap_ses_572_839682=RxSyIEIr/3ityr+9LSfwB/LtFFkAAAAA0QOXji099nPIcfMaJODvtw==; CHSESSION=phrniie8m1e054hbco9e2csk33; visid_incap_839682=Y2evWq9iQ/CnqNS44KGhUwJph1gAAAAAQkIPAAAAAACADgp8AXbBFIqXKAfjUUs6sYsKhlDkdpeE; ajs_user_id=null; ajs_group_id=null; ajs_anonymous_id=%22c3a40103-d7a0-4019-b654-5d22756afa5f%22; _ga=GA1.2.1509432278.1485269260; intercom-id-jv6shdwn=920223f0-e140-4bfe-86a0-052aafec36e2; App[AnonymousId]=Q2FrZQ%3D%3D.pua3hG9eoNdgt6LUv3cW%2FiJsM3uDpdeVzhi8y9J%2B9CIkJE6unwnkHS3HKDnT7LDP55LX4q3qkHwzsRs92SFjqfajGnXW48jTosQWH6cOf7o2Vh5N7t1PSr00Lj%2F3CH5DXnE%3D; _gid=GA1.2.1724015756.1494465040"));
        	
//            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response stat0us: " + status);
                    }
                }
            };
            
            responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
            
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
