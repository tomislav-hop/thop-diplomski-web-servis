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
import databaseConnection.objects.DbOrderImpl;
import databaseConnection.objects.DbOrderItemsImpl;
import databaseConnection.objects.DbPackageImpl;
import databaseConnection.objects.DbStatusImpl;
import databaseConnection.objects.DbUserImpl;
import gsonObjects.Item;
import gsonObjects.Status;

public class MySQLConnectionHelper {

	private static final String PROP_FILE_NAME = "databaseData.properties";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String FULL_CONNECTION_URL;
	private String db_url;
	private String db_name;
	private String user;
	private String pass;

	private Connection conn = null;

	//================================================================================
	// Database configuration and connections
	//================================================================================
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

	//================================================================================
	// Item methods
	//================================================================================
	public String addItem(Item item) {
		return new DbItemImpl().addItem(item, conn);
	}

	public List<Item> getAllItems() {
		return new DbItemImpl().getAllItems(conn);
	}

	public Item getItem(String itemId) {
		return new DbItemImpl().getItem(itemId, conn);
	}

	//================================================================================
	// Status methods
	//================================================================================
	public String addStatus(Status status) {
		return new DbStatusImpl().addStatus(status, conn);
	}

	public List<Status> getAllStatuses() {
		return new DbStatusImpl().getAllStatuses(conn);
	}

	public Status getStatus(String statusId) {
		return new DbStatusImpl().getStatus(statusId, conn);
	}

	//================================================================================
	// Package methods
	//================================================================================
	public String addPackage(gsonObjects.Package itemPackage) {
		return new DbPackageImpl().addPackage(itemPackage, conn);
	}

	public List<gsonObjects.Package> getAllPackages() {
		return new DbPackageImpl().getAllPackages(conn);
	}

	public gsonObjects.Package getPackage(String packageId) {
		return new DbPackageImpl().getPackage(packageId, conn);
	}

	//================================================================================
	// Order methods
	//================================================================================
	public String addOrder(gsonObjects.Order order) {
		return new DbOrderImpl().addOrder(order, conn);
	}

	public gsonObjects.Order getOrder(String orderId) {
		return new DbOrderImpl().getOrder(orderId, conn);
	}

	public List<gsonObjects.Order> getAllOrders() {
		return new DbOrderImpl().getAllOrders(conn);
	}

	//================================================================================
	// Order items methods
	//================================================================================

	public String addOrderItems(gsonObjects.OrderItems[] orderItems, String orderId) {
		return new DbOrderItemsImpl().addOrderItems(orderItems, orderId, conn);
	}

	public gsonObjects.OrderItems getOrderItem(String orderItemId) {
		return new DbOrderItemsImpl().getOrderItem(orderItemId, conn);
	}

	public List<gsonObjects.OrderItems> getAllOrderItemsForOrder(String orderId) {
		return new DbOrderItemsImpl().getAllItemsFromOrder(conn, orderId);
	}
	
	//================================================================================
	// Login
	//================================================================================
	
	public String login(String username, String password){
		return new DbUserImpl().login(username, password, conn);
	}
	
}
