package org.shil.omr;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class FetchGetBodyUtil {
	
	public static void main(String[] args){
		superGetUrl("http://localhost/xmr.html");
//		fetchUrlBody("http://localhost/xmr.html");
	}
	
	public static String superGetUrl(String url) {
		 WebClient webClient = new WebClient();
		 try {
		 do {
			try {
				
			 HtmlPage page1 = webClient.getPage(url);
			 System.out.println(page1.asText());
			 HtmlPage page2 = webClient.getPage(url);
			 System.out.println(page2.asText());
			}catch(Exception e) {
				e.printStackTrace();
			}
		 }while(true);
		
		}catch(Exception e) {
		
		}finally {
			webClient.close();
		}
		
		return null;
	}
	
	
	public static String fetchUrlBody(String cardurl){
		String responseBody = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	HttpGet httpget = new HttpGet(cardurl);
//        	HttpPost httpget = new HttpPost(cardurl);

        	// Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
//                	Header[] headers = response.getAllHeaders();
//                	for(Header header : headers){
//                		System.out.println("in for "+header);
//                	}
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
            System.out.println("----------------------------------------");
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
