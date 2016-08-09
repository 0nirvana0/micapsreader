package com.lq.micaps.diamond;

import java.util.List;

import com.lq.micaps.diamond.datatype.DiamondData02;
import com.lq.micaps.diamond.datatype.DiamondHeader02;

/**
 * DESCRIPTION: Micaps diamond  data  
 * @author LQ
 *
 */
public class MicapsFile02 {
	private List<DiamondData02> diamondData02;
	private DiamondHeader02 diamondHeader02;
	private String fileName;

	public List<DiamondData02> getDiamondData02() {
		return diamondData02;
	}

	public void setDiamondData02(List<DiamondData02> diamondData02) {
		this.diamondData02 = diamondData02;
	}

	public DiamondHeader02 getDiamondHeader02() {
		return diamondHeader02;
	}

	public void setDiamondHeader02(DiamondHeader02 diamondHeader02) {
		this.diamondHeader02 = diamondHeader02;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
