package com.lq.micaps.diamond.datatype;

import com.lq.common.atmos.Algorithm;

public class DiamondData02 {
	public static final int SIZE = 10; // 数据长度(个数)

	public long Station; // 区站号
	public float Longitude, Latitude, Altitude; // 经度 纬度 拔海高度
	public int Level; // 站点级别
	public float H, T, T_Td; // 高度 温度 温度露点差
	public float dd, ff; // 风向 风速

	public DiamondData02() {// 构造函数
		setDefault();
	}

	public void setDefault() {// 设置数据为缺省值
		Longitude = Algorithm.defaultValue;
		Latitude = Algorithm.defaultValue;
		Altitude = Algorithm.defaultValue;
		Level = (new Double(Algorithm.defaultValue)).intValue();
		H = Algorithm.defaultValue;
		T = Algorithm.defaultValue;
		T_Td = Algorithm.defaultValue;
		dd = (int) Algorithm.defaultValue;
		ff = (int) Algorithm.defaultValue;
	}

	@Override
	public String toString() {
		return String.format("%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s", Station, Longitude, Latitude, Altitude, Level, H, T, T_Td, dd, ff);
	}

}