package com.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {
	
	private static BasicDataSource dataSource = null;
	private static DataSource gDataSource() {
		
		if(dataSource==null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("1234");
			dataSource.setUrl("jdbc:mysql://localhost:3306/netflix1");
			
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
			
			
		}
		
		return dataSource;
	}

	
	public static Connection getConnection() throws SQLException {
		
		return gDataSource().getConnection();
	}
	

}
