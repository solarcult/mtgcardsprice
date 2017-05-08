package org.shil.mtg.entity;

import java.util.Calendar;
import java.util.Date;

public class CardPrice {
	
	private String set;
	private String name;
	private Date fetchDate;
	private double price;
	private int year;
	private int month;
	private int day;
	private int week;
	private int hour;
	private int minute;
	
	public CardPrice(String set, String name, Calendar fetchCalendar,double price){
		this.set = set;
		this.name = name;
		this.fetchDate = fetchCalendar.getTime();
		this.price = price;
		this.year = fetchCalendar.get(Calendar.YEAR);
		this.month = fetchCalendar.get(Calendar.MONTH)+1;
		this.day = fetchCalendar.get(Calendar.DAY_OF_MONTH);
		this.week = fetchCalendar.get(Calendar.WEEK_OF_MONTH);
		this.hour = fetchCalendar.get(Calendar.HOUR_OF_DAY);
		this.minute = fetchCalendar.get(Calendar.MINUTE);
	}

	public String getSet() {
		return set;
	}

	public String getName() {
		return name;
	}

	public Date getFetchDate() {
		return fetchDate;
	}

	public double getPrice() {
		return price;
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

	@Override
	public String toString() {
		return "CardPrice [set=" + set + ", name=" + name + ", fetchDate=" + fetchDate + ", price=" + price + ", year="
				+ year + ", month=" + month + ", day=" + day + ", week=" + week + ", hour=" + hour + ", minute="
				+ minute + "]";
	}
	
}
