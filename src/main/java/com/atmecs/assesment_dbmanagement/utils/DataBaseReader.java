package com.atmecs.assesment_dbmanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseReader {
	protected Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	public DataBaseReader() {	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://ATMECSINLT-085\\SQLEXPRESS;database=AssesmentTwo;integratedSecurity=true;" ; 
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection Executed");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  
		
	}
	public String getCellData(String tableName,String columnheader,String uniqueId) throws SQLException {
		String columnArray = null;
		stmt=con.createStatement();
		String readQuery="Select "+columnheader+" from "+tableName+" where TestCase_Id="+"'"+uniqueId+"'"+";";
		rs=stmt.executeQuery(readQuery);
		while(rs.next())
		{
		columnArray=rs.getString(columnheader).toString();
		}
		return columnArray;
	}
}
