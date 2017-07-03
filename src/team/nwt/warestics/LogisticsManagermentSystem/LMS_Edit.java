package team.nwt.warestics.LogisticsManagermentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class LMS_Edit {
	public static final String url = "jdbc:mysql://106.14.5.141/warestics";	// 数据库地址
	public static final String name = "com.mysql.jdbc.Driver";						// 驱动名
	public static final String user = "general";									// 数据库用户名
	public static final String password = "123456";									// 用户密码
	
	public Connection conn = null;				// 建立一个空的Connection对象
	public PreparedStatement pst = null;		// 建立一个空的PreparedStatement对象

	public LMS_Edit(String sql) {
		try {
			Class.forName(name);										// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);	// 获取数据库连接
			pst = conn.prepareStatement(sql);							// 准备执行语句
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
