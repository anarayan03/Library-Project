package com.cg.library.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection 
{
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		
		FileInputStream fileInputStream = new FileInputStream("Resources/database.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		String url = properties.getProperty("url");
		String usrename =  properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver1 = properties.getProperty("driver");
		
		Class.forName(driver1);
		Connection connection = DriverManager.getConnection(url,usrename,password);
		return connection;
		
	}

	public static DbConnection getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
