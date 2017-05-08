package org.shil.mtg.utils;

import java.io.IOException;
import java.util.Calendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.shil.mtg.entity.CardPrice;

public class FetchCardPriceUtil {
	
	public static String ONLINE_PRICE_START = "<div class='price-box-price'>";
	public static String ONLINE_PRICE_STOP = "</div>";
	public static String TITLE_START = "<title>";
	public static String TITLE_END = "</title>";
	public static String BEFORE_NAME = ","; 
	public static String SET_END = ")";
	
	public static CardPrice fetchCardPrice(String cardurl){
		CardPrice cardPrice = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
        	
        	HttpGet httpget = new HttpGet(cardurl);

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
            String responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
            
            int titleStart = responseBody.indexOf(TITLE_START);
            int titleContentStart = titleStart + TITLE_START.length();
            int titleEnd = responseBody.indexOf(TITLE_END);
            String title = responseBody.substring(titleContentStart,titleEnd);
            String name = title.substring(0,title.indexOf(BEFORE_NAME));
            String set = title.substring(title.indexOf(BEFORE_NAME)+2, title.indexOf(SET_END)+1);
            Calendar now = Calendar.getInstance();
            
            int start = responseBody.indexOf(ONLINE_PRICE_START);
            int price_start = start+ONLINE_PRICE_START.length();
            int price_stop = responseBody.indexOf(ONLINE_PRICE_STOP,price_start);
            String online_price = responseBody.substring(price_start, price_stop);
//            System.out.println(Double.valueOf(online_price));
          
            cardPrice = new CardPrice(set,name,now,Double.parseDouble(online_price));
            
//            System.out.println(cardPrice);
            
            
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
        
        return cardPrice;
	}

	public static void main(String[] args){
		System.out.println(fetchCardPrice("https://www.mtggoldfish.com/price/Aether+Revolt/Metallic+Mimic#online"));
	}
}
