package com.lq.micaps.diamond;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.lq.common.atmos.DiamondType;
import com.lq.common.atmos.Field;
import com.lq.micaps.diamond.datatype.DiamondData01;
import com.lq.micaps.diamond.datatype.DiamondData02;
import com.lq.micaps.diamond.datatype.DiamondHeader01;
import com.lq.micaps.diamond.datatype.DiamondHeader02;

/**
 * DESCRIPTION: Micaps diamond  data  
 * 可以读取1 2 类数据
 * @author LQ
 *
 */
public class MicapsFile {

	private static List<String> open_(String fname) throws IOException {
		List<String> allData = new ArrayList<String>();
		File f = new File(fname);
		if (!f.exists() || !f.canRead()) {
			return null;
		}
		// read file header
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fname), "gb2312");// gb2312 支持汉字

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String lineString;
		StringTokenizer st;
		while (null != (lineString = bufferedReader.readLine())) {
			st = new StringTokenizer(lineString, " ");
			while (st.hasMoreTokens()) {
				allData.add(st.nextToken());
			}
		}

		inputStreamReader.close();

		return allData;
	}

	public static MicapsFile01 openAsDiamond1(String fname) throws IOException {
		DiamondType diamondType = new DiamondType();
		MicapsFile01 micapsFile01 = new MicapsFile01();
		List<String> allData = open_(fname);

		if (allData.size() < DiamondData01.SIZE + DiamondHeader01.SIZE || !DiamondHeader01.SYMBOL.equalsIgnoreCase((String) allData.get(0)) || DiamondHeader01.TYPE != Integer.parseInt((String) allData.get(1))) {
			return null;
		}
		// 读文件头
		DiamondHeader01 diamondHeader = diamondType.readHeader1(allData);

		List<DiamondData01> diamondDatas = null;
		// 读数据
		if (diamondHeader.getCount() > 0 && allData.size() >= DiamondHeader01.SIZE + diamondHeader.getCount() * DiamondData01.SIZE) {
			diamondDatas = diamondType.readData1(allData);
			micapsFile01.setFileName(fname);
		}
		micapsFile01.setDiamondData01(diamondDatas);
		micapsFile01.setDiamondHeader01(diamondHeader);
		return micapsFile01;
	}

	public static MicapsFile02 openAsDiamond2(String fname) throws IOException {
		DiamondType diamondType = new DiamondType();
		MicapsFile02 micapsFile02 = new MicapsFile02();
		List<String> allData = open_(fname);

		if (allData.size() < DiamondData02.SIZE + DiamondHeader02.SIZE || !DiamondHeader02.SYMBOL.equalsIgnoreCase((String) allData.get(0)) || DiamondHeader02.TYPE != Integer.parseInt((String) allData.get(1))) {
			return null;
		}
		// 读文件头
		DiamondHeader02 diamondHeader = diamondType.readHeader2(allData);

		List<DiamondData02> diamondDatas = null;
		// 读数据
		if (diamondHeader.getCount() > 0 && allData.size() >= DiamondHeader02.SIZE + diamondHeader.getCount() * DiamondData02.SIZE) {
			diamondDatas = diamondType.readData2(allData);
			micapsFile02.setFileName(fname);
		}

		micapsFile02.setDiamondData02(diamondDatas);
		micapsFile02.setDiamondHeader02(diamondHeader);
		return micapsFile02;
	}

	public static Dataset openAsDataset(String fname) throws IOException {

		Dataset dataset = new Dataset();
		DiamondType diamondType = new DiamondType();

		List<String> allData = open_(fname);

		Gson gson = new Gson();
		int type = Integer.parseInt((String) allData.get(1));
		// 1类数据
		if (type == DiamondHeader01.TYPE) {
			if (allData.size() < DiamondData01.SIZE + DiamondHeader01.SIZE || !DiamondHeader01.SYMBOL.equalsIgnoreCase((String) allData.get(0))) {
				return null;
			}
			List<Field> fields = diamondType.getFields1();

			String fieldsJson = gson.toJson(fields);
			dataset.setFields(fieldsJson);

			// 读文件头
			DiamondHeader01 diamondHeader = diamondType.readHeader1(allData);
			String headerJson = gson.toJson(diamondHeader);
			dataset.setHeader(headerJson);

			// 读数据
			if (diamondHeader.getCount() > 0 && allData.size() >= DiamondHeader01.SIZE + diamondHeader.getCount() * DiamondData01.SIZE) {

				List<DiamondData01> diamondDatas = diamondType.readData1(allData);

				dataset.setDiamondDatas(gson.toJson(diamondDatas));// Total time 283 ms

				dataset.setFileName(fname);

			} else {
				dataset.setFileName("");
			}
		}

		// 2类数据
		if (type == DiamondHeader02.TYPE) {

			if (allData.size() < DiamondData02.SIZE + DiamondHeader02.SIZE || !DiamondHeader02.SYMBOL.equalsIgnoreCase((String) allData.get(0))) {
				return null;
			}
			List<Field> fields = diamondType.getFields2();
			String fieldsJson = gson.toJson(fields);
			dataset.setFields(fieldsJson);
			// 读文件头
			DiamondHeader02 diamondHeader = diamondType.readHeader2(allData);
			String headerJson = gson.toJson(diamondHeader);
			dataset.setHeader(headerJson);

			// 读数据
			if (diamondHeader.getCount() > 0 && allData.size() >= DiamondHeader02.SIZE + diamondHeader.getCount() * DiamondData02.SIZE) {
				List<DiamondData02> diamondDatas = diamondType.readData2(allData);
				dataset.setDiamondDatas(gson.toJson(diamondDatas));
				dataset.setFileName(fname);
			} else {
				dataset.setFileName("");
			}
		}

		return dataset;

	}

}
