package com.lq.micaps.diamond.datatype;

import java.text.DecimalFormat;

public class DiamondData01 {
	public static final int SIZE = 26; // 数据长度(个数)

	public long Station; // 区站号
	public float Longitude, Latitude, Altitude; // 经度 纬度 海拔高度
	public int Level, N, dd, ff; // 站点级别 总云量 风向 风速
	public int P, P3; // 海平面气压(本站气压) 3小时变压
	public int W1, W2; // 过去天气1 过去天气2
	public float R6; // 6小时降水
	public int Cl, Nh, h; // 低云状 低云量 低云高
	public float Td;// 露点
	public float vv; // 能见度
	public int WW; // 现在天气
	public float T; // 气温
	public int Cm, Ch; // 中云状 高云状
	// 注；从2001-02-28 11时起Diamond01格式增加两个数据
	public int Sign1, Sign2; // 标志1 标志2，若Sign1=1,Sign2=2时T24,P24为24小时变温变压，否则为船向船速
	public int T24, P24; // 24小时变温、24小时变压

	public DiamondData01() {
		Station = 59046;
		Longitude = 0;
		Latitude = 0;
		Altitude = 0;
		Level = 0;
		N = 0;
		dd = 0;
		ff = 0;
		P = 0;
		P3 = 0;
		W1 = 0;
		W2 = 0;
		R6 = 0;
		Cl = 0;
		Nh = 0;
		h = 0;
		Td = 0;
		vv = 0;
		WW = 0;
		T = 0;
		Cm = 0;
		Ch = 0;
		Sign1 = 1;
		Sign2 = 2;
		T24 = 0;
		P24 = 0;
	}

	public void reset(int value) {// 重设除站点信息之后的其他数据
		DecimalFormat fmt = new DecimalFormat("0");
		int intValue = Integer.parseInt(String.valueOf(fmt.format(value)));
		N = intValue;
		dd = intValue;
		ff = intValue;
		P = intValue;
		P3 = intValue;
		W1 = intValue;
		W2 = intValue;
		R6 = 0;
		Cl = intValue;
		Nh = intValue;
		h = intValue;
		Td = value;
		vv = value;
		WW = intValue;
		T = value;
		Cm = intValue;
		Ch = intValue;
		Sign1 = 1;
		Sign2 = 2;
		T24 = intValue;
		P24 = intValue;
	}

	public String get(int index) {
		DecimalFormat df = new DecimalFormat();
		String value = "";
		switch (index) {
		case 0:
			value = df.format(this.Station);
		case 1:
			value = df.format(this.Longitude);
		case 2:
			value = df.format(this.Latitude);
		case 3:
			value = df.format(this.Altitude);
		case 4:
			value = df.format(this.Level);
		case 5:
			value = df.format(this.N);
		case 6:
			value = df.format(this.dd);
		case 7:
			value = df.format(this.ff);
		case 8:
			value = df.format(this.P);
		case 9:
			value = df.format(this.P3);
		case 10:
			value = df.format(this.W1);
		case 11:
			value = df.format(this.W2);
		case 12:
			value = df.format(this.R6);
		case 13:
			value = df.format(Cl);
		case 14:
			value = df.format(Nh);
		case 15:
			value = df.format(h);
		case 16:
			value = df.format(Td);
		case 17:
			value = df.format(vv);
		case 18:
			value = df.format(WW);
		case 19:
			value = df.format(T);
		case 20:
			value = df.format(Cm);
		case 21:
			value = df.format(Sign1);
		case 22:
			value = df.format(Sign2);
		case 23:
			value = df.format(T24);
		case 24:
			value = df.format(P24);
		default:
			value = "";
		}
		return value;
	}

	@Override
	public String toString() {
		return String.format("%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s", Station, Longitude, Latitude, Altitude, Level, N, dd, ff, P, P3, W1, W2, R6, Cl, Nh, h, Td, vv, WW, T, Cm, Ch, Sign1, Sign2, T24, P24);

	}

}