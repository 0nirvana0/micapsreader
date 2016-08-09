package com.lq.common.atmos;

import java.util.ArrayList;
import java.util.List;

import com.lq.micaps.diamond.datatype.DiamondData01;
import com.lq.micaps.diamond.datatype.DiamondData02;
import com.lq.micaps.diamond.datatype.DiamondHeader01;
import com.lq.micaps.diamond.datatype.DiamondHeader02;

public class DiamondType {

	public List<Field> getFields1() {
		List<Field> fields = new ArrayList<Field>();
		fields.add(new Field("Station", "long", "区站号"));
		fields.add(new Field("Longitude", "float", "经度"));
		fields.add(new Field("Latitude", "float", "纬度"));
		fields.add(new Field("Altitude", "float", "拔海高度"));
		fields.add(new Field("Level", "int", "站点级别"));
		fields.add(new Field("N", "int", "总云量"));
		fields.add(new Field("dd", "int", "风向"));
		fields.add(new Field("ff", "int", "风速"));
		fields.add(new Field("P", "float", "海平面气压(本站气压)"));
		fields.add(new Field("P3", "int", "3小时变压"));
		fields.add(new Field("W1", "int", "过去天气1"));
		fields.add(new Field("W2", "int", "过去天气2"));
		fields.add(new Field("R6", "float", "6小时降水"));
		fields.add(new Field("Cl", "int", "低云状"));
		fields.add(new Field("Nh", "int", "低云量"));
		fields.add(new Field("h", "int", "低云高"));
		fields.add(new Field("Td", "float", "露点"));
		fields.add(new Field("vv", "float", "能见度"));
		fields.add(new Field("WW", "int", "现在天气"));
		fields.add(new Field("T", "float", "气温"));
		fields.add(new Field("Cm", "int", "中云状"));
		fields.add(new Field("Ch", "int", "高云状"));
		fields.add(new Field("Sign1", "int", "标志1"));
		fields.add(new Field("Sign2", "int", "标志2"));
		fields.add(new Field("T24", "int", "24小时变温"));
		fields.add(new Field("P24", "int", "24小时变压"));
		return fields;
	}

	public DiamondHeader01 readHeader1(List<String> data) {
		DiamondHeader01 header = new DiamondHeader01();
		header.setSymbol(data.get(0)); // 数据标志 diamond
		header.setType(Integer.parseInt(data.get(1))); // 数据类型 2
		header.setTitle(data.get(2)); // 标题
		header.setYear(Integer.parseInt(data.get(3))); // 年
		header.setMonth(Integer.parseInt(data.get(4))); // 月
		header.setDay(Integer.parseInt(data.get(5))); // 日
		header.setHour(Integer.parseInt(data.get(6))); // 时次
		header.setCount(Integer.parseInt(data.get(7))); // 站点总数
		return header;

	}

	public List<DiamondData01> readData1(List<String> allData) {
		List<DiamondData01> diamondDatas = new ArrayList<DiamondData01>();

		for (int i = DiamondHeader01.SIZE; i < allData.size(); i = i + DiamondData01.SIZE) {
			DiamondData01 diamondData = new DiamondData01();
			diamondData.Station = Long.parseLong(allData.get(i + 0)); // 区站号
			diamondData.Longitude = Float.parseFloat(allData.get(i + 1)); // 经度
			diamondData.Latitude = Float.parseFloat(allData.get(i + 2)); // 纬度
			diamondData.Altitude = Float.parseFloat(allData.get(i + 3)); // 拔海高度
			diamondData.Level = Integer.parseInt(allData.get(i + 4)); // 站点级别
			diamondData.N = Integer.parseInt(allData.get(i + 5));// 总云量
			diamondData.dd = Integer.parseInt(allData.get(i + 6));// 风向
			diamondData.ff = Integer.parseInt(allData.get(i + 7));// 风速
			diamondData.P = Integer.parseInt(allData.get(i + 8));// 海平面气压(本站气压)
			diamondData.P3 = Integer.parseInt(allData.get(i + 9));// 3小时变压
			diamondData.W1 = Integer.parseInt(allData.get(i + 10));// 过去天气1
			diamondData.W2 = Integer.parseInt(allData.get(i + 11));// 过去天气2
			diamondData.R6 = Float.parseFloat(allData.get(i + 12));// 6小时降水
			diamondData.Cl = Integer.parseInt(allData.get(i + 13));// 低云状
			diamondData.Nh = Integer.parseInt(allData.get(i + 14));// 低云量
			diamondData.h = Integer.parseInt(allData.get(i + 15));// 低云高
			diamondData.Td = Float.parseFloat(allData.get(i + 16));// 露点
			diamondData.vv = Float.parseFloat(allData.get(i + 17));// 能见度
			diamondData.WW = Integer.parseInt(allData.get(i + 18));// 现在天气
			diamondData.T = Float.parseFloat(allData.get(i + 19));// 气温
			diamondData.Cm = Integer.parseInt(allData.get(i + 20));// 中云状
			diamondData.Ch = Integer.parseInt(allData.get(i + 21));// 高云状
			diamondData.Sign1 = Integer.parseInt(allData.get(i + 22));// 标志1
			diamondData.Sign2 = Integer.parseInt(allData.get(i + 23));// 标志2
			diamondData.T24 = Integer.parseInt(allData.get(i + 24));// 24小时变温
			diamondData.P24 = Integer.parseInt(allData.get(i + 25));// 4小时变压

			diamondDatas.add(diamondData);
		}
		return diamondDatas;
	}

	public List<Field> getFields2() {
		List<Field> fields = new ArrayList<Field>();
		fields.add(new Field("Station", "long", "区站号"));
		fields.add(new Field("Longitude", "float", "经度"));
		fields.add(new Field("Latitude", "float", "纬度"));
		fields.add(new Field("Altitude", "float", "拔海高度"));
		fields.add(new Field("Level", "int", "站点级别"));
		fields.add(new Field("H", "float", "高度"));
		fields.add(new Field("T", "float", "温度"));
		fields.add(new Field("T_Td", "float", "温度露点差"));
		fields.add(new Field("dd", "float", "风向"));
		fields.add(new Field("ff", "float", "风速"));
		return fields;
	}

	public DiamondHeader02 readHeader2(List<String> data) {
		DiamondHeader02 header = new DiamondHeader02();
		header.setSymbol(data.get(0)); // 数据标志 diamond
		header.setType(Integer.parseInt(data.get(1))); // 数据类型 2
		header.setTitle(data.get(2)); // 标题
		header.setYear(Integer.parseInt(data.get(3))); // 年
		header.setMonth(Integer.parseInt(data.get(4))); // 月
		header.setDay(Integer.parseInt(data.get(5))); // 日
		header.setHour(Integer.parseInt(data.get(6))); // 时次
		header.setLayer(Integer.parseInt(data.get(7))); // 层次
		header.setCount(Integer.parseInt(data.get(8))); // 站点总数

		return header;

	}

	public List<DiamondData02> readData2(List<String> allData) {
		List<DiamondData02> diamondDatas = new ArrayList<DiamondData02>();
		for (int i = DiamondHeader02.SIZE; i < allData.size(); i = i + DiamondData02.SIZE) {
			DiamondData02 diamondData = new DiamondData02();
			diamondData.Station = Long.parseLong(allData.get(i + 0)); // 区站号
			diamondData.Longitude = Float.parseFloat(allData.get(i + 1)); // 经度
			diamondData.Latitude = Float.parseFloat(allData.get(i + 2)); // 纬度
			diamondData.Altitude = Float.parseFloat(allData.get(i + 3)); // 拔海高度
			diamondData.Level = Integer.parseInt(allData.get(i + 4)); // 站点级别
			diamondData.H = Float.parseFloat(allData.get(i + 5)); // 高度
			diamondData.T = Float.parseFloat(allData.get(i + 6)); // 温度
			diamondData.T_Td = Float.parseFloat(allData.get(i + 7)); // 温度露点差
			diamondData.dd = Float.parseFloat(allData.get(i + 8)); // 风向
			diamondData.ff = Float.parseFloat(allData.get(i + 9)); // 风速
			diamondDatas.add(diamondData);
		}
		return diamondDatas;
	}
}
