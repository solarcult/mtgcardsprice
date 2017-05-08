package org.shil.mtg;

import org.shil.mtg.db.CardPriceDaoImpl;
import org.shil.mtg.entity.CardPrice;
import org.shil.mtg.utils.FetchCardPriceUtil;

public class MainFetchThread {

	public static void main(String[] args) {
		String[] urls = CardsList.getCardsList();
		for(String url : urls){
			CardPrice cp = FetchCardPriceUtil.fetchCardPrice(url);
			System.out.println(cp);
			CardPriceDaoImpl.insertCardPrice(cp);
		} 
	}

}
