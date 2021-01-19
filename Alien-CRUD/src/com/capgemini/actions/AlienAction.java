package com.capgemini.actions;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.capgemini.exceptions.AlienException;
import com.capgemini.models.Alien;
import com.capgemini.services.AlienService;
import com.capgemini.services.AlienServiceImp;
import com.opensymphony.xwork2.ActionSupport;

public class AlienAction extends ActionSupport {
	
	private Alien alien;
	
	private AlienService alienService = new AlienServiceImp();
	
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	
	@Override
	public void validate() {
		System.out.println(getAlien());
		if(getAlien() == null || getAlien().getAlienId() == null) {
			addFieldError("alien.alienId", "Alien Id is required");
		}
		if(getAlien() == null ||getAlien().getAlienName() == null || StringUtils.isEmpty(getAlien().getAlienName())) {
			addFieldError("alien.alienName", "Alien Name is required");
		}
		if(getAlien() == null || getAlien().getPlanetName() == null || StringUtils.isEmpty(getAlien().getPlanetName())) {
			addFieldError("alien.planetName", "Planet Name is required");
		}
	}
	
	public String addAlien() {
		
		if(alienService.addAlien(alien)) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String editAlien() {
		try {
			alienService.editAlien(alien);
			alien = null;
			return SUCCESS;
		} catch (AlienException ex) {
			return ERROR;
		}
	}
	
	public String deleteAlien() {
		try {
			if(alienService.deleteAlien(getAlien().getAlienId())) {
				return SUCCESS;
			}
			return ERROR;
		} catch(AlienException ex) {
			return ERROR;
		}
		
	}

}
