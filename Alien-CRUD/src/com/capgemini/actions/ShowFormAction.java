package com.capgemini.actions;

import org.apache.commons.lang3.StringUtils;

import com.capgemini.models.Alien;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFormAction extends ActionSupport {

	private Alien alien = null;
	
	@Override
	public String execute() throws Exception {
		if(getAlien() == null) {
			return ERROR;
		}
		if(getAlien().getAlienId() == null) {
			return ERROR;
		}
		if(getAlien().getAlienName() == null || StringUtils.isEmpty(getAlien().getAlienName())) {
			return ERROR;
		}
		if(getAlien().getPlanetName() == null || StringUtils.isEmpty(getAlien().getPlanetName())) {
			return ERROR;
		}
		return SUCCESS;
	}

	public Alien getAlien() {
		return alien;
	}

	public void setAlien(Alien alien) {
		this.alien = alien;
	}
}
