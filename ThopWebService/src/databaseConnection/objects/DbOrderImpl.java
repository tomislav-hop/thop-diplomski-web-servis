package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.Order;

public class DbOrderImpl {

	public String addOrder(Order order, Connection conn) {

		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `order` VALUES (NULL, '" + order.getOrderOrdered() + "', '" + order.getOrderAdress() + "', '" + order.getOrderDate() + "', '" + order.getAdditionalNotes() + "', '" + order.getStatusId() + "');";
			System.out.println("SQL: " + sql);
			stmt.executeUpdate(sql);
			System.out.println("Order successfully added.");
			return "Order successfully added.";
		} catch (SQLException ex) {
			Logger.getLogger(DbOrderImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Order add failed: " + ex.toString();
		}
	}

	public Order getOrder(String orderId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `order` WHERE id_order = " + orderId + ";";
			System.out.println("SQL:" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			Order returnOrder = null;
			while (rs.next()) {
				return returnOrder = new Order(rs.getInt("id_order"), rs.getString("orderedBy"), rs.getString("adress"), rs.getString("orderDate"), rs.getString("additionalNotes"), rs.getInt("id_status"));
			}
			return returnOrder;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> getAllOrders(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `order`;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Order> listOfOrders = new ArrayList<>();
			while (rs.next()) {
				listOfOrders.add(new Order(rs.getInt("id_order"), rs.getString("orderedBy"), rs.getString("adress"), rs.getString("orderDate"), rs.getString("additionalNotes"), rs.getInt("id_status")));
			}
			return listOfOrders;
		} catch (SQLException e) {
			Logger.getLogger(DbOrderImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
}
