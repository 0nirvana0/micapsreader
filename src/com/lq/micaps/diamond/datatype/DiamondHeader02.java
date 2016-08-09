package com.lq.micaps.diamond.datatype;

public class DiamondHeader02 {
	public static final int TYPE = 2;
	public static final int SIZE = 9;
	public static final String SYMBOL = "diamond";
	private String symbol;// 数据标志 diamond
	private Integer type; // 数据类型 2
	private String title;// 标题
	private Integer year; // 年
	private Integer month; // 月
	private Integer day; // 日
	private Integer hour; // 时次
	private Integer layer; // 层次
	private Integer count; // 站点总数

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
