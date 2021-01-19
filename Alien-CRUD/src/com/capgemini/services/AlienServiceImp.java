package com.capgemini.services;

import java.util.List;

import com.capgemini.dao.AlienRepo;
import com.capgemini.dao.AlienRepoJDBC;
import com.capgemini.exceptions.AlienException;
import com.capgemini.models.Alien;

public class AlienServiceImp implements AlienService {

	private AlienRepo alienRepo = new AlienRepoJDBC();
	
	public AlienRepo getAlienRepo() {
		return alienRepo;
	}

	public void setAlienRepo(AlienRepo alienRepo) {
		this.alienRepo = alienRepo;
	}
	
	@Override
	public Boolean addAlien(Alien alien) {
		return alienRepo.addAlien(alien);
	}

	@Override
	public Boolean deleteAlien(Integer alienId) throws AlienException {
		return alienRepo.deleteAlien(alienId);
	}

	@Override
	public Alien editAlien(Alien alien) throws AlienException {
		return alienRepo.editAlien(alien);
	}

	@Override
	public List<Alien> getAllAliens() throws AlienException {
		return alienRepo.getAllAliens();
	}

}
