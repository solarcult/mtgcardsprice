package org.shil.mtg.utils;

import java.util.Calendar;

import org.shil.mtg.entity.CardPrice;

public class AnalyzeCardhoarderCardPriceUtil {
	
	public static String SELL_PRICE_START = "class=\"card-ordering-details\">";
	public static String SELL_PRICE_STOP = "TIX";
	public static String BUY_PRICE_START = "Our Buy Price:";
	public static String BUY_PRICE_STOP = "tickets";
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
        String title = responseBody.substring(titleContentStart,titleEnd).trim();
        String name = title.substring(0,title.lastIndexOf(BEFORE_NAME)).trim();
        String set = title.substring(title.lastIndexOf(BEFORE_NAME)+2, title.indexOf(SET_END)+1).trim();
        Calendar now = Calendar.getInstance();
            
        int sell_start = responseBody.indexOf(SELL_PRICE_START);
        int sell_price_start = sell_start + SELL_PRICE_START.length();
        int sell_price_stop = responseBody.indexOf(SELL_PRICE_STOP,sell_price_start);
        String sell_price = responseBody.substring(sell_price_start, sell_price_stop).trim();
        
        int buy_start = responseBody.indexOf(BUY_PRICE_START);
        String buy_price = "0";
        if(buy_start!=-1){
	        int buy_price_start = buy_start + BUY_PRICE_START.length();
	        int buy_price_stop = responseBody.indexOf(BUY_PRICE_STOP,buy_price_start);
	        buy_price = responseBody.substring(buy_price_start, buy_price_stop).trim();
        }
        
        cardPrice = new CardPrice(set,name,now,Double.parseDouble(sell_price),Double.parseDouble(buy_price),"cardhoarder");            
//        System.out.println(cardPrice);
            
        return cardPrice;
	}

	public static void main(String[] args){
		System.out.println(fetchCardPrice("https://www.cardhoarder.com/cards/62021"));
		String title= "Oviya Pashiri, Sage Lifecrafter, Kaladesh (KLD)";
		String name = title.substring(0,title.lastIndexOf(BEFORE_NAME)).trim();
        String set = title.substring(title.lastIndexOf(BEFORE_NAME)+2, title.indexOf(SET_END)+1).trim();
        System.out.println(name +"   vs    "+set);
		
	}
}
