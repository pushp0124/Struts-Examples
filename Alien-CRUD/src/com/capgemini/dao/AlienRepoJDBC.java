package com.capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.exceptions.AlienException;
import com.capgemini.models.Alien;

public class AlienRepoJDBC implements AlienRepo {

	private Connection connection;
	private static final String URL = "jdbc:h2:~/struts";
	private static final String userName = "sa";
	private static final String password = "";
	private static final String driverClassName = "org.h2.Driver";


	public Connection getConnection() throws AlienException {
		try {
			if(connection == null || connection.isClosed()) {
				Class.forName(driverClassName);
				connection = DriverManager.getConnection(URL, userName, password);
			}
		} catch(Exception ex) {
			System.out.println(ex);
			throw new AlienException("Connection can not be instantiated");
		}
		return connection;
	}



	public Boolean addAlien(Alien alien) {

		try {
			String sql = "INSERT INTO ALIEN VALUES(?,?,?)";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, alien.getAlienId());
			preparedStatement.setString(2, alien.getAlienName());
			preparedStatement.setString(3, alien.getPlanetName());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
					return true;
				} catch (Exception e) {
					return true;
				}
			}
		}
		return true;
	}

	
	public List<Alien> getAllAliens() throws AlienException {

		List<Alien> aliens = new ArrayList<>();
		try {

			String sql = "SELECT * FROM ALIEN";
			Statement preparedStatement = getConnection().createStatement();
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next()){
				Integer alienId  = resultSet.getInt("alienId");
				String alienName = resultSet.getString("alienName");
				String planetName = resultSet.getString("planetName");
				Alien alien = new Alien(alienId, alienName, planetName);
				System.out.println(alien);
				aliens.add(alien);
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new AlienException("Error fetching aliens !");
		} finally {
			if (connection != null) {
				try {
					connection.close();
					return aliens;
				} catch (Exception e) {
					throw new AlienException("Error fetching aliens !");
				}
			}
		}
		return aliens;

	}
	

	@Override
	public Alien getAlien(Integer _alienId) throws AlienException {
		
		Alien alien = null;
		try {

			String sql = "SELECT * FROM ALIEN WHERE ALIENID = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, _alienId);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next()){
				Integer alienId  = resultSet.getInt("alienId");
				String alienName = resultSet.getString("alienName");
				String planetName = resultSet.getString("planetName");
				alien = new Alien(alienId, alienName, planetName);
				break;
			}
			resultSet.close();
		} catch (Exception e) {
			throw new AlienException("Error fetching alien !");
		} finally {
			if (connection != null) {
				try {
					connection.close();
					return alien;
				} catch (Exception e) {
					throw new AlienException("Error fetching alien !");
				}
			}
		}
		return alien;
	}
	
	
	public Alien editAlien(Alien alien) throws AlienException {

		try {
			String sql = "UPDATE ALIEN SET ALIENNAME = ?, PLANETNAME = ? WHERE ALIENID = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, alien.getAlienName());
			preparedStatement.setString(2, alien.getPlanetName());
			preparedStatement.setInt(3, alien.getAlienId());
			
			preparedStatement.executeUpdate();
			System.out.println(" Shuld be called Updated");

		} catch (Exception e) {
			throw new AlienException("Error updating alien !");
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println(alien + "Updated");
					return alien;
				} catch (Exception e) {
					System.out.println("Updated");
					throw new AlienException("Error updating alien !");
				}
			}
		}
		return alien;
	}

	public Boolean deleteAlien(Integer alienId) {
		try {
			String sql = "DELETE FROM ALIEN WHERE ALIENID = ?";
			
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, alienId);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}






}
