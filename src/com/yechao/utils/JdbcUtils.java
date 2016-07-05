package com.yechao.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Administrator Jdbc操作的工具类
 */
public class JdbcUtils {
	/**
	 * 释放connection连接
	 * 
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static DataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource("ProjectOne");
	}

	/**
	 * 返回数据源的一个connection对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();

	}
}
