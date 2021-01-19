package com.capgemini.actions;

import java.util.List;

import com.capgemini.exceptions.AlienException;
import com.capgemini.models.Alien;
import com.capgemini.services.AlienService;
import com.capgemini.services.AlienServiceImp;
import com.opensymphony.xwork2.ActionSupport;

public class GetAliensAction extends ActionSupport {
	
	private AlienService alienService = new AlienServiceImp();
	
	private List<Alien> allAliens;
	
	public List<Alien> getAllAliens() {
		return allAliens;
	}

	public void setAllAliens(List<Alien> allAliens) {
		this.allAliens = allAliens;
	}
	
	@Override
	public String execute() throws Exception {
		try {
			setAllAliens(alienService.getAllAliens());
			return SUCCESS;
		} catch (AlienException ex) {
			System.out.println(ex);
			return ERROR;
		}
	}
	
	
	
}
