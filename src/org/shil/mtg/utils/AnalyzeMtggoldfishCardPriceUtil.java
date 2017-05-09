package org.shil.mtg.utils;

import java.util.Calendar;

import org.shil.mtg.entity.CardPrice;

public class AnalyzeMtggoldfishCardPriceUtil {
	
	public static String ONLINE_PRICE_START = "<div class='price-box-price'>";
	public static String ONLINE_PRICE_STOP = "</div>";
	public static String TITLE_START = "<title>";
	public static String TITLE_END = "</title>";
	public static String BEFORE_NAME = ","; 
	public static String SET_END = ")";
	
	public static CardPrice fetchCardPrice(String cardurl){
		CardPrice cardPrice = null;
		String responseBody = FetchUrlBodyUtil.fetchUrlBody(cardurl);
            
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
          
        cardPrice = new CardPrice(set,name,now,Double.parseDouble(online_price),0,"mtggoldfish");            
//        System.out.println(cardPrice);
            
        return cardPrice;
	}

	public static void main(String[] args){
		System.out.println(fetchCardPrice("https://www.mtggoldfish.com/price/Aether+Revolt/Metallic+Mimic#online"));
	}
}
