////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.sql.*;

public class ResultSetDemo {

	public static void main(String[] args) throws SQLException {


		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// 1. Get a Connection to Database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
					"student",
					"student"
			);

			// 2. Run Query

			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select id, last_name, first_name, salary from employees");

			// 3. Get Result set metadata
			ResultSetMetaData rsMetaData = myRs.getMetaData();;

			// Display info
			int columnCount = rsMetaData.getColumnCount();
			System.out.println("Column Count: " + columnCount);
			System.out.println();

			for (int column = 1; column <= columnCount; column++){
				System.out.println("Column Name: " + rsMetaData.getColumnName(column));
				System.out.println("Column Type Name: " + rsMetaData.getColumnTypeName(column));
				System.out.println("Is Nullable: " + rsMetaData.isNullable(column));
				System.out.println("Is Auto Increment: " + rsMetaData.isAutoIncrement(column));
				System.out.println();
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);
			}
		}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

}

