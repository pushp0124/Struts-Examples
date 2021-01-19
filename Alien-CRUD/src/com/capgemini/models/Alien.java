package com.capgemini.models;

public class Alien {
	
	private Integer alienId;
	private String alienName;
	private String planetName;
	
	
	public Alien() {
		super();
	}
	public Alien(Integer alienId, String alienName, String planetName) {
		super();
		this.alienId = alienId;
		this.alienName = alienName;
		this.planetName = planetName;
	}
	public Integer getAlienId() {
		return alienId;
	}
	public void setAlienId(Integer alienId) {
		this.alienId = alienId;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	@Override
	public String toString() {
		return "Alien [alienId=" + alienId + ", alienName=" + alienName + ", planetName=" + planetName + "]";
	}

}
