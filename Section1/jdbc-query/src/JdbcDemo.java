////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.sql.*;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException{

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String user = "student";
		String pass = "student";

		try {

			// 1. Get Connection to database
			myConn = DriverManager.getConnection(
					dbUrl,
					user,
					pass
			);
			System.out.println("Database connection successfull!\n");

			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Execute SQL Query
			myRs = myStmt.executeQuery("select * from employees");

			// 4. Process the result set

			while (myRs.next()){
				System.out.println(
						myRs.getString("last_name") + ", " + myRs.getString("first_name")
				);
			}

			} catch(Exception e) {
				e.printStackTrace();
		}
	}
}
