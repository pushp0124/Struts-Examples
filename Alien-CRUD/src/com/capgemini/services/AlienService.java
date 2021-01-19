package com.capgemini.services;

import java.util.List;

import com.capgemini.exceptions.AlienException;
import com.capgemini.models.Alien;

public interface AlienService {

	public Boolean addAlien(Alien alien);
	
	public Alien editAlien(Alien alien) throws AlienException;
	
	public Boolean deleteAlien(Integer alienId) throws AlienException;
	
	public List<Alien> getAllAliens() throws AlienException;
	
	
}
