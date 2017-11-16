package org.shil.mtg.entity;

import java.util.Calendar;

public class CardPrice {
	
	private String mset;
	private String name;
	private Calendar fetchDate;
	private double sellprice;
	private double buyprice;
	private int year;
	private int month;
	private int day;
	private int week;
	private int hour;
	private int minute;
	private String site;
	
	public CardPrice(String mset, String name, Calendar fetchCalendar,double sellprice,double buyprice,String site){
		this.mset = mset;
		this.name = name;
		this.fetchDate = fetchCalendar;
		this.sellprice = sellprice;
		this.buyprice = buyprice;
		this.year = fetchCalendar.get(Calendar.YEAR);
		this.month = fetchCalendar.get(Calendar.MONTH)+1;
		this.day = fetchCalendar.get(Calendar.DAY_OF_MONTH);
		this.week = fetchCalendar.get(Calendar.DAY_OF_WEEK)-1;
		this.hour = fetchCalendar.get(Calendar.HOUR_OF_DAY);
		this.minute = fetchCalendar.get(Calendar.MINUTE);
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public Calendar getFetchDate() {
		return fetchDate;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getWeek() {
		return week;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public String getMset() {
		return mset;
	}

	public double getBuyprice() {
		return buyprice;
	}

	public double getSellprice() {
		return sellprice;
	}

	public String getSite() {
		return site;
	}

	@Override
	public String toString() {
		return "CardPrice [mset=" + mset + ", name=" + name  + ", \tsellprice=" + sellprice + ", \tbuyprice=" + buyprice
				 + ", site=" + site + "]";
	}

	
}
