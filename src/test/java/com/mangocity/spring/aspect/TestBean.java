package com.mangocity.spring.aspect;

public class TestBean {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void test(){
		System.out.println("TestBean begin{}");
	}
}
