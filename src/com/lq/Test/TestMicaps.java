package com.lq.Test;

import java.io.IOException;
import java.util.List;

import com.lq.micaps.diamond.Dataset;
import com.lq.micaps.diamond.MicapsFile;
import com.lq.micaps.diamond.MicapsFile01;
import com.lq.micaps.diamond.MicapsFile02;
import com.lq.micaps.diamond.Recordset;
import com.lq.micaps.diamond.datatype.DiamondData01;
import com.lq.micaps.diamond.datatype.DiamondData02;
import com.lq.micaps.diamond.datatype.DiamondHeader01;
import com.lq.micaps.diamond.datatype.DiamondHeader02;

public class TestMicaps {
	public static void main(String[] args) {
		testDataSet();
		// testMicapsFile01();
		// testMicapsFile02();
	}

	public static void testDataSet() {
		long lStart = System.currentTimeMillis();
		try {
			Dataset dataset = MicapsFile.openAsDataset("E:/data/EN_micaps/surface/plot/16070220.000");
			System.out.println(dataset.getFields());
			System.out.println(dataset.getFileName());
			System.out.println(dataset.getHeader());

			for (int i = 0; i < dataset.recordSize(); i++) {
				Recordset recordset = dataset.get(i);
				String lat = recordset.getAsString("Latitude");
				System.out.println(lat);
				System.out.println(recordset.getAsJson());
				System.out.println(recordset);
			}
			System.out.println(String.format("Total time %d ms", System.currentTimeMillis() - lStart));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testMicapsFile01() {
		long lStart = System.currentTimeMillis();
		try {
			MicapsFile01 micapsFile01 = MicapsFile.openAsDiamond1("E:/data/EN_micaps/surface/plot/16070220.000");
			DiamondHeader01 header01 = micapsFile01.getDiamondHeader01();
			System.out.println(header01.getTitle());
			System.out.println(micapsFile01.getFileName());

			List<DiamondData01> diamondData01s = micapsFile01.getDiamondData01();
			for (DiamondData01 diamondData01 : diamondData01s) {
				System.out.println(diamondData01);
				System.out.println(diamondData01.Latitude);
			}
			System.out.println(String.format("Total time %d ms", System.currentTimeMillis() - lStart));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testMicapsFile02() {
		long lStart = System.currentTimeMillis();
		try {
			MicapsFile02 micapsFile02 = MicapsFile.openAsDiamond2("E:/data/EN_micaps/high/plot/500/16041908.000");
			DiamondHeader02 header02 = micapsFile02.getDiamondHeader02();
			System.out.println(header02.getTitle());
			System.out.println(micapsFile02.getFileName());
			List<DiamondData02> diamondData02s = micapsFile02.getDiamondData02();
			for (DiamondData02 diamondData02 : diamondData02s) {
				System.out.println(diamondData02);
				System.out.println(diamondData02.Latitude);
			}
			System.out.println(String.format("Total time %d ms", System.currentTimeMillis() - lStart));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
