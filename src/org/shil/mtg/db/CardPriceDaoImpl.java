package org.shil.mtg.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.shil.mtg.entity.CardPrice;
/**
 * 
 * @author LiangJingJing
 * 
 * 2017-05-09 21:52
 */
public class CardPriceDaoImpl {

	public static void insertCardPrice(Connection connection, CardPrice cardprice){

		PreparedStatement preparedStatement = null;

		try{

			preparedStatement = connection.prepareStatement(

				"insert into cardsprice(year,month,day,hour,minute,week,fetchdate,name,mset,sellprice,buyprice,site)"

				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)"

			);

			preparedStatement.setInt(1, cardprice.getYear());

			preparedStatement.setInt(2, cardprice.getMonth());

			preparedStatement.setInt(3, cardprice.getDay());

			preparedStatement.setInt(4, cardprice.getHour());

			preparedStatement.setInt(5, cardprice.getMinute());

			preparedStatement.setInt(6, cardprice.getWeek());

			preparedStatement.setTimestamp(7, new Timestamp(cardprice.getFetchDate().getTimeInMillis()));

			preparedStatement.setString(8, cardprice.getName());

			preparedStatement.setString(9, cardprice.getMset());

			preparedStatement.setDouble(10, cardprice.getSellprice());
			
			preparedStatement.setDouble(11, cardprice.getBuyprice());
			
			preparedStatement.setString(12, cardprice.getSite());
			
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
