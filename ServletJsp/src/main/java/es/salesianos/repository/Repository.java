package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.Connectionh2;
import es.salesianos.model.Paises;



public class Repository {
	private static final String jdbcUrl = "jdbc:h2:file:C:/Users/Máyuri/Desktop/ExamenServ/Servlet/ServletJsp/src/main\resources/DBtest2";
	Connectionh2 manager = new Connectionh2();
	
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
	}
