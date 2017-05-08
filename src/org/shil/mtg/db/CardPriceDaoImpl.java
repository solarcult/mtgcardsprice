package org.shil.mtg.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.shil.mtg.entity.CardPrice;

public class CardPriceDaoImpl {

	public static void insertCardPrice(CardPrice cardprice){
		Connection connection = DataBaseManager.getConnection();

		PreparedStatement preparedStatement = null;

		try{

			preparedStatement = connection.prepareStatement(

				"insert into cardsprice(year,month,day,hour,minute,week,fetchdate,name,mset,price)"

				+ " values(?,?,?,?,?,?,?,?,?,?)"

			);

			

			preparedStatement.setInt(1, cardprice.getYear());

			preparedStatement.setInt(2, cardprice.getMonth());

			preparedStatement.setInt(3, cardprice.getDay());

			preparedStatement.setInt(4, cardprice.getHour());

			preparedStatement.setInt(5, cardprice.getMinute());

			preparedStatement.setInt(6, cardprice.getWeek());

			preparedStatement.setTimestamp(7, new Timestamp(cardprice.getFetchDate().getTimeInMillis()));

			preparedStatement.setString(8, cardprice.getName());

			preparedStatement.setString(9, cardprice.getSet());

			preparedStatement.setDouble(10, cardprice.getPrice());


			preparedStatement.executeUpdate();

			

		}catch(Exception e){

			e.printStackTrace();

		}finally{

			try {

				if(preparedStatement!=null) preparedStatement.close();

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}
	}
	
}
