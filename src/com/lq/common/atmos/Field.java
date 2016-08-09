package com.lq.common.atmos;

public class Field {
	private String name;
	private String type;
	private String describe;

	protected Field(String name, String type, String describe) {
		super();
		this.name = name;
		this.type = type;
		this.describe = describe;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected String getDescribe() {
		return describe;
	}

	protected void setDescribe(String describe) {
		this.describe = describe;
	}

}
