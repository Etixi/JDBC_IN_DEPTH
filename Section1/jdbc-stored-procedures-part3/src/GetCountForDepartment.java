////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.sql.*;

public class GetCountForDepartment {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {

			// Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
					"student",
					"student"
			);

			String theDepartment = "Engineering";

			// Prepare the store procedure call
			myStmt = myConn
					.prepareCall("{call get_count_for_department(?, ?)}");

			// Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);

			// Call the store procedure
			System.out.println("Calling stored procedures. get_count_for_department('" + theDepartment + "', ?)");
			myStmt.execute();
			System.out.println("Finished calling stored procedures");

			// Get the value of the OUT parameter
			int theCount = myStmt.getInt(2);

			System.out.println("\nThe count = " + theCount);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myConn, myStmt);
		}
	}

	private static void close(Connection myConn, Statement myStmt) throws SQLException {
		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}

