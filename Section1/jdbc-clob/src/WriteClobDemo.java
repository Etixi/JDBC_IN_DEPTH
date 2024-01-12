////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class WriteClobDemo {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		FileReader input = null;


		try {

			// 1. Get a connection a database
			myConn = DriverManager.getConnection(

					"jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
					"student",
					"student"
			);

			// 2. Prepare statement
			String sql = "update employees set resume=? where email='john.doe@foo.com'";
			myStmt = myConn.prepareStatement(sql);

			// 3. Set parameter for resume file name
			File theFile = new File("files/sample_resume.txt");
			input = new FileReader(theFile);
			myStmt.setCharacterStream(1, input);

			System.out.println("Reading input file: " + theFile.getAbsolutePath());

			// 4. Execute statement
			System.out.println("\nStoring resume in database " + theFile);
			System.out.println(sql);

			myStmt.executeUpdate();

			System.out.println("\nCompleted successfully");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}

			close(myConn, myStmt);
		}
	}

	private static void close(Connection myConn, Statement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

}
