package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.model.Plan;
import com.model.Subscriptor;

public class SubsDao {
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	// guardar
	public boolean guardar(Subscriptor subs) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO usuario (id, nombre, apellidoPaterno,apellidoMaterno,servicio, fechaNacimeinto, plan, estatus) VALUES(?,?,?,?,?,?,?,?) ";
			statement = connection.prepareStatement(sql);

			statement.setString(1, null);
			statement.setString(2, subs.getNombre());
			statement.setString(3, subs.getApellidoPaterno());
			statement.setString(4, subs.getApellidoMaterno());
			statement.setString(5, subs.getServicio());
			statement.setString(6, subs.getFechaNacimiento());
			statement.setObject(7, subs.getPlan());
			statement.setString(8, subs.getEstatus());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}


public Plan obtenerPlan(int idplan) throws SQLException {
		
		ResultSet resulset = null;
		Plan pl = new Plan();
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "SELECT * FROM plan WHERE idPlan=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idplan);
			resulset = statement.executeQuery(sql);
			
			
			if(resulset.next()) {
		
			pl.setIdPlan(resulset.getInt(1));
			pl.setNombre(resulset.getString(2));
			pl.setImportef(Float.parseFloat(resulset.getString(3)));
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return pl;
	}

	
	
	
	// editar
	public boolean editar(Subscriptor subs) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE usuario SET nombre=?, apellidoPaterno=?,apellidoMaterno=?,servicio=?, fechaNacimiento=?, plan=?, estatus=? WHERE id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, subs.getNombre());
			statement.setString(2, subs.getApellidoPaterno());
			statement.setString(3, subs.getApellidoMaterno());
			statement.setString(4, subs.getServicio());
			statement.setString(5, subs.getFechaNacimiento());
			statement.setObject(6, subs.getPlan());
			statement.setString(7, subs.getEstatus());
			statement.setInt(8, subs.getId());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// eliminar
	public boolean eliminar(int idSubs) throws SQLException {

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM usuario WHERE id =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSubs);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;

	}

	// lista de subs
	public List<Subscriptor> obtenerSubs(int idSubs) throws SQLException {
		ResultSet resulset = null;
		List<Subscriptor> listaUsuarios = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "SELECT * FROM usuario";
			resulset = statement.executeQuery(sql);
			
			while (resulset.next()) {
				
				Subscriptor s = new Subscriptor();
				s.setId(resulset.getInt(1));
				s.setNombre(resulset.getString(2));
				s.setApellidoPaterno(resulset.getString(3));
				s.setApellidoMaterno(resulset.getString(4));
				s.setServicio(resulset.getString(5));
				s.setFechaNacimiento(resulset.getString(6));
				s.setPlan(new Plan(resulset.getInt(1),resulset.getString(2),resulset.getFloat(3)));
				s.setEstatus(resulset.getString(7));
				
				listaUsuarios.add(s);
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	// obtener subs
	public Subscriptor obtenerSub(int idSubs) throws SQLException {
		
		ResultSet resulset = null;
		Subscriptor s = new Subscriptor();
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "SELECT * FROM usuario WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSubs);
			resulset = statement.executeQuery(sql);
			
			
			if(resulset.next()) {
		
				
				s.setId(resulset.getInt(1));
				s.setNombre(resulset.getString(2));
				s.setApellidoPaterno(resulset.getString(3));
				s.setApellidoMaterno(resulset.getString(4));
				s.setServicio(resulset.getString(5));
				s.setFechaNacimiento(resulset.getString(6));
				s.setPlan(new Plan(resulset.getInt(1),resulset.getString(2),resulset.getFloat(3)));
				s.setEstatus(resulset.getString(7));

				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return s;
	}

	// obtener
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();

	}
	

}
