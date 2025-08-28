package haru.kieu.connectDB;

import java.sql.DriverManager;

import java.sql.Connection;

public class ConnectDB {

	private final String serverName = "DESKTOP-4IDN9VP\\SQLEXPRESS";
	private final String dbName = "LTWebTest";
	private final String portNumber = "1433";
	private final String instance = "SQLEXPRESS";
	private final String userID = "sa";
	private final String password = "vmxkieu123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(new ConnectDB().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
