package team.nwt.warestics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/warestics?user=root&password=123456";
	public BaseDao(){
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection(url);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("连接成功");
	
		
	}
	public Connection getConnection(){
		return connection;
	}
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
