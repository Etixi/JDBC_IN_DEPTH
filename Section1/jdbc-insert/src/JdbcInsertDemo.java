////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.sql.*;

public class JdbcInsertDemo {

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
			System.out.println("Inserting a new employee to database!\n");

			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Insert a new employees
			int rowsAffected  = myStmt.executeUpdate(
					"insert into employees " +
					"(last_name, first_name, email, department, salary)" +
					"values " +
							"('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)"
			);

			// 4. Verify this by getting a list of employees
			myRs = myStmt.executeQuery("select * from employees order by last_name");

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
