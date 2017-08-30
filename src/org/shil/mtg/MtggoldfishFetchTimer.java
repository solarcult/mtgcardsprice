package org.shil.mtg;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.shil.mtg.db.CardPriceDaoImpl;
import org.shil.mtg.db.MysqlDataBaseManager;
import org.shil.mtg.db.PostgresqlDataBaseManager;
import org.shil.mtg.entity.CardPrice;
import org.shil.mtg.utils.AnalyzeMtggoldfishCardPriceUtil;

public class MtggoldfishFetchTimer {

	public static void main(String[] args) {
		
		TimerTask timetask = new TimerTask(){
			
			@Override
			public void run() {
				String[] urls = CardsList.getMtggoldfishCardsList();
				for(String url : urls){
					try{
						CardPrice cp = AnalyzeMtggoldfishCardPriceUtil.fetchCardPrice(url);
						System.out.println(cp);
						CardPriceDaoImpl.insertCardPrice(PostgresqlDataBaseManager.getConnection(),cp);
//						CardPriceDaoImpl.insertCardPrice(MysqlDataBaseManager.getConnection(),cp);
						Thread.sleep(1042);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				System.out.println(Calendar.getInstance().getTime()+" mtggoldfish job is done.");
			}
		};
		
		long period = 5 * 60 * 1000;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timetask, 128, period);
	}

}
