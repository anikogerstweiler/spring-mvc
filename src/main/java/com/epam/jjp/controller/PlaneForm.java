package com.epam.jjp.controller;

import com.epam.jjp.domain.Plane.PlaneType;

public class PlaneForm {
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
	
	public int getHp() {
		return hp;
	}
}
