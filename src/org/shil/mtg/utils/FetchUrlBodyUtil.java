package org.shil.mtg.utils;

import java.io.IOException;

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

	public static String fetchUrlBody(String cardurl){
		String responseBody = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	HttpGet httpget = new HttpGet(cardurl);
        	httpget.addHeader(new BasicHeader("Cookie","CHSESSION=ogs0lhsem07g0a5tkriplthm21; visid_incap_839682=Y2evWq9iQ/CnqNS44KGhUwJph1gAAAAAQUIPAAAAAAAYEQkvAfcEm4qd7eZwOSYl; ajs_user_id=null; ajs_group_id=null; ajs_anonymous_id=%22c3a40103-d7a0-4019-b654-5d22756afa5f%22; _ga=GA1.2.1509432278.1485269260; intercom-id-jv6shdwn=920223f0-e140-4bfe-86a0-052aafec36e2; App[AnonymousId]=Q2FrZQ%3D%3D.pua3hG9eoNdgt6LUv3cW%2FiJsM3uDpdeVzhi8y9J%2B9CIkJE6unwnkHS3HKDnT7LDP55LX4q3qkHwzsRs92SFjqfajGnXW48jTosQWH6cOf7o2Vh5N7t1PSr00Lj%2F3CH5DXnE%3D; _gid=GA1.2.14003846.1494347141; incap_ses_261_839682=n0b3RcMVjCFmNDu2BESfA4veEVkAAAAASwfcTtr7L/YC8YjVrD8zJA==; incap_ses_434_839682=eqIcZ245lFJUCc8TP+EFBrbrEVkAAAAAEojk2w6NJqMwBxoZ8aEchw==; _gat=1"));
        	
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
