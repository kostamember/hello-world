package dbForLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection dbConn;
	
		public static Connection getConnection()
		{
			Connection conn = null;
			try {
				String user ="c##demoscott";
				String pwd = "tiger";
				//String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				// jdbc:oracle:thin:@127.0.0.1:1521:XE
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pwd);
				
				//System.out.println("Database�� ����Ǿ����ϴ�. \n");
						
						
			} catch(ClassNotFoundException cnfe) {
				System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
			} catch(SQLException sqle) {
				System.out.println("DB ���ӽ��� : "+sqle.toString());
			} catch(Exception e) {
				System.out.println("Unknown error");
				e.printStackTrace();
			}
			return conn;
		}
}
