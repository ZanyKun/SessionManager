package session.holder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import session.dao.DbUtil;

public class testConnection {
	public static void main(String... args) {
		String insertQuery = "insert into BillDetails values(seq_bill_num.nextval, ?, ?, ?, ?, " + LocalDateTime.now() + ")";
		String selectQuery = "select * from Consumers";
		try(Connection c = DbUtil.getConnection();
			PreparedStatement s = c.prepareStatement(insertQuery);
			PreparedStatement s1 = c.prepareStatement(selectQuery);){
			System.out.println(s1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}