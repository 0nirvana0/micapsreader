package com.lq.micaps.diamond;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Dataset {
	private String header;
	private String fields;
	private String fileName;
	private JsonArray array;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setDiamondDatas(String diamondDatas) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(diamondDatas);
		JsonArray array = element.getAsJsonArray();
		this.array = array;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Recordset get(int index) {
		Recordset recordset = new Recordset();
		JsonObject object = array.get(index).getAsJsonObject();
		recordset.setRecordset(object);
		return recordset;
	}

	public int recordSize() {
		return array.size();
	}
}
