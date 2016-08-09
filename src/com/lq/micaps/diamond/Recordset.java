package com.lq.micaps.diamond;

import com.google.gson.JsonObject;

public class Recordset {
	private JsonObject recordset;

	public void setRecordset(JsonObject recordset) {
		this.recordset = recordset;
	}

	public String getAsString(String name) {
		return recordset.get(name).getAsString();

	}

	public int getAsInt(String name) {
		return recordset.get(name).getAsInt();

	}

	public float getAsLong(String name) {
		return recordset.get(name).getAsLong();

	}

	public float getAsFloat(String name) {
		return recordset.get(name).getAsFloat();

	}

	public double getAsDouble(String name) {
		return recordset.get(name).getAsDouble();

	}

	public String getAsJson() {
		return recordset.toString();
	}

	@Override
	public String toString() {
		return recordset.toString();
	}
}
