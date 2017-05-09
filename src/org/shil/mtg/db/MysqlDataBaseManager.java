package org.shil.mtg.db;

import java.sql.Connection;

import java.sql.DriverManager;



/**

 * 数据库连接工具类

 *  

 * @author ShiL

 * 2007-2-8 1:33:20

 */

public class MysqlDataBaseManager
{
	public static Connection connection;

	public static Connection getConnection()

	{
		if(connection == null){
			try

			{
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mtgcards", "root", "12345");

				connection = conn;
			}

			catch (Exception e)

			{
				e.printStackTrace();
			}

		}

		

		return connection;

	}

}
