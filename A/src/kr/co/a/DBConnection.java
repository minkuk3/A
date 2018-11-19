package kr.co.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	public static Connection getConnection() throws Exception{
		
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hkitedu");
			
			System.out.println("연결완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs){
		
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(ps != null){
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
