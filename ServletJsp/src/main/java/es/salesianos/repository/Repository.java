package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.salesianos.connection.Connectionh2;
import es.salesianos.model.Idiomas;
import es.salesianos.model.Paises;



public class Repository {
	private static final String jdbcUrl = "jdbc:h2:file:C:/Users/Máyuri/Desktop/ExamenServ/Servlet/ServletJsp/src/main/resources/DBtest2";
	Connectionh2 manager = new Connectionh2();
	
	public Paises search(Paises paisFormulario) {
		Paises paisInDataBase = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM PAISES AS p, IDIOMAS as i WHERE p.idioma=i.idioma AND pais = ?");
			prepareStatement.setString(1, paisFormulario.getPais());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				paisInDataBase = new Paises();
				paisInDataBase.setPais(resultSet.getString(1));
				paisInDataBase.setIdioma(resultSet.getString(2));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
		return paisInDataBase;
	}
	
	public void insert(Paises paisFormulario) {
		// TODO Auto-generated method stub
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO PAISES (pais, idioma) VALUES ('"+paisFormulario.getPais()+"', '"+paisFormulario.getIdioma()+"')");
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);

	}
	public Idiomas searchIdioma(Idiomas idiomaFormulario) {
		Idiomas idiomaInDataBase = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM IDIOMAS WHERE idioma = ?");
			prepareStatement.setString(1, idiomaFormulario.getIdioma());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				idiomaInDataBase = new Idiomas();
				idiomaInDataBase.setIdioma(resultSet.getString(1));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
		return idiomaInDataBase;
	}
	public void insertIdioma(Idiomas idiomaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO IDIOMAS (idioma) VALUES ('"+idiomaFormulario.getIdioma()+"')");
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);

	}
	public void delete(String idioma) {
		Connection conn = manager.open(jdbcUrl);
		try {

			PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM PAISES AS p, IDIOMAS AS i WHERE p.idioma=i.idioma AND i.idioma=?");
			prepareStatement.setString(1, idioma);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
	}
	}
