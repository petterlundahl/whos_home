package com.larmen.whoshome;

public class Person {

	private String name;
	private boolean isHome;
	
	public Person(String name, boolean isHome) {
		this.name = name;
		this.isHome = isHome;
	}

	public String getName() {
		return name;
	}
	
	public boolean isHome() {
		return isHome;
	}
}
