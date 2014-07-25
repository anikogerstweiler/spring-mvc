package com.epam.jjp.domain;

public class Plane {
	private String name;
	private PlaneType type;
	private int hp;
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(final PlaneType type) {
		this.type = type;
	}
	
	public PlaneType getType() {
		return type;
	}
	
	public void setHp(final int hp) {
		this.hp = hp;
	}
	
	public void changeHp(final int delta) {
		hp += delta;
		if (hp < 0) {
			hp = 0;
		}
	}
	
	public int getHp() {
		return hp;
	}
	
	
	public enum PlaneType {
		CIVIL,
		MILITARY,
		CHARITY;
	}
}
