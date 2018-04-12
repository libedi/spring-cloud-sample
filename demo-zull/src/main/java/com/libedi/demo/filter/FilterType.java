package com.libedi.demo.filter;

public enum FilterType {
	
	PRE("pre"), ROUTE("route"), POST("post"), ERROR("error");
	
	private String value;
	private FilterType(String value) {
		this.value = value;
	}
	public String toString() {
		return this.value;
	}

}
