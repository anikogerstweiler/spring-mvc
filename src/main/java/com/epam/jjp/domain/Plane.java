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
		hp -= delta;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (hp != other.hp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
