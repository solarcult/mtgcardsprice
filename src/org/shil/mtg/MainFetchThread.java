package org.shil.mtg;

import org.shil.mtg.utils.FetchCardPriceUtil;

public class MainFetchThread {

	public static void main(String[] args) {
		String[] urls = CardsList.getCardsList();
		for(String url : urls){
			System.out.println(FetchCardPriceUtil.fetchCardPrice(url));
		} 
	}

}
