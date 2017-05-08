import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class MtgFirstTest {
	
	public static String ONLINE_PRICE_START = "<div class='price-box-price'>";
	public static String ONLINE_PRICE_STOP = "</div>";
	
	public static void main(String[] args){
		B();
	}
	
	public static void B(){

		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {        	
        	
        	String trys = "https://www.mtggoldfish.com/price/Kaladesh/Depala+Pilot+Exemplar#online";
        	String metellicMimic = "https://www.mtggoldfish.com/price/Aether+Revolt/Metallic+Mimic#online";

        	HttpGet httpget = new HttpGet(metellicMimic);

            System.out.println("Executing request " + httpget.getRequestLine());

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
            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
            
            int start = responseBody.indexOf(ONLINE_PRICE_START);
            int price_start = start+ONLINE_PRICE_START.length();
            int price_stop = responseBody.indexOf(ONLINE_PRICE_STOP,price_start);
            String online_price = responseBody.substring(price_start, price_stop);
            System.out.println(Double.valueOf(online_price));
            
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
	}
}
