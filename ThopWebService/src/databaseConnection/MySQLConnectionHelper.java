package databaseConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import databaseConnection.objects.DbItemImpl;
import gsonObjects.ItemGson;

public class MySQLConnectionHelper {

	private static final String PROP_FILE_NAME = "databaseData.properties";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String FULL_CONNECTION_URL;
	private String db_url;
	private String db_name;
	private String user;
	private String pass;

	private Connection conn = null;

	private void loadWebServiceProperties() {
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(PROP_FILE_NAME));
			db_url = prop.getProperty("db_url");
			db_name = prop.getProperty("db_name");
			user = prop.getProperty("user");
			pass = prop.getProperty("pass");
		} catch (Exception e) {
			Logger.getLogger(MySQLConnectionHelper.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public MySQLConnectionHelper() {
		loadWebServiceProperties();
		FULL_CONNECTION_URL = db_url + db_name;
	}

	public void connectToDatabase() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to: " + FULL_CONNECTION_URL);
			System.out.println("User data: " + user + "\t" + pass);
			conn = DriverManager.getConnection(FULL_CONNECTION_URL, user, pass);
			System.out.println("Connection successuful.");
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(MySQLConnectionHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void closeDatabaseConnection() {
		try {
			conn.close();
			System.out.println("Database connection closed.");
		} catch (Exception e) {
			Logger.getLogger(MySQLConnectionHelper.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public String addItem(ItemGson item) {
		return new DbItemImpl().addItem(item, conn);
	}

	public List<ItemGson> getAllItems() {
		return new DbItemImpl().getAllItems(conn);
	}
	
	public ItemGson getItem(String itemId){
		return new DbItemImpl().getItem(itemId, conn);
	}
}
