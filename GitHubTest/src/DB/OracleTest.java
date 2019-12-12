package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String quary = "SELECT * FROM Book";
			
			conn = DBConnection2.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			System.out.println("Bookid BookName Publisher price");
			System.out.println("================================");
		
		while(rs.next()) {
			int bookid = rs.getInt(1);
			String bookname = rs.getString(2);
			String publisher = rs.getString(3);
			int price = rs.getInt(4);
			
			String result = bookid+" "+bookname+" "+publisher+" "+price;
			System.out.println(result);
		}
		} catch (SQLException sqle) {
			System.out.println("Select문에서 예외 발생");
			sqle.printStackTrace();
		} finally {
			// DB 연결을 종료한다.
			try {
				if(rs!=null) {
					rs.close();
				}if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		
	}

