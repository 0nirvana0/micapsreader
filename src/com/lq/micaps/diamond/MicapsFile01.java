package com.lq.micaps.diamond;

import java.util.List;

import com.lq.micaps.diamond.datatype.DiamondData01;
import com.lq.micaps.diamond.datatype.DiamondHeader01;

/**
 * DESCRIPTION: Micaps diamond  data  
 * 可以读取1 2 类数据
 * @author LQ
 *
 */
public class MicapsFile01 {
	private List<DiamondData01> diamondData01;
	private DiamondHeader01 diamondHeader01;
	private String fileName;

	public List<DiamondData01> getDiamondData01() {
		return diamondData01;
	}

	public void setDiamondData01(List<DiamondData01> diamondData01) {
		this.diamondData01 = diamondData01;
	}

	public DiamondHeader01 getDiamondHeader01() {
		return diamondHeader01;
	}

	public void setDiamondHeader01(DiamondHeader01 diamondHeader01) {
		this.diamondHeader01 = diamondHeader01;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
