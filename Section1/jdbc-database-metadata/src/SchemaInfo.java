////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

import java.sql.*;

import java.sql.*;

public class SchemaInfo {

	public static void main(String[] args) throws SQLException {

		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;  // Set types to null

		Connection myConn = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
					"student",
					"student"
			);

			// 2. Get metadata
			DatabaseMetaData databaseMetaData = myConn.getMetaData();

			// 3. Get list of tables
			System.out.println("List of Tables");
			System.out.println("*".repeat(40));

			myRs = databaseMetaData.getTables("demo",null, null, null);

			while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}

			// 4. Get list of columns
			System.out.println("\n\nList of Columns");
			System.out.println("*".repeat(40));

			myRs = databaseMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);

			while (myRs.next()) {
				System.out.println(myRs.getString("COLUMN_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(myConn, myRs);
		}

	}

	private static void close(Connection myConn, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
