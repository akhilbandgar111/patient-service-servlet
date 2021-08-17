package com.patient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=patient;user=sa;password=Akhil@123ct";
	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		synchronized (DbConnection.class)
		{
			if (con == null)
			{
				Class.forName(DRIVER_CLASS);
				con = DriverManager.getConnection(URL);
			}
		}
		return con;
	}
}
