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
			String sql = "INSERT INTO narudzba VALUES (NULL, '" + order.getOrderOrdered() + "', '" + order.getOrderAdress() + "', '" + order.getOrderDate() + "', '" + order.getAdditionalNotes() + "', '1', '" + order.getStatusId() + "');";
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
			String sql = "SELECT * FROM narudzba WHERE id_narudzba = " + orderId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			Order returnOrder = null;
			while (rs.next()) {
				return returnOrder = new Order(rs.getInt("id_narudzba"), rs.getString("narucio"), rs.getString("adresa"), rs.getString("datum_narudzbe"), rs.getString("dodatne_biljeske"), rs.getInt("status_id_status"));
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
			String sql = "SELECT * FROM narudzba;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Order> listOfOrders = new ArrayList<>();
			while (rs.next()) {
				listOfOrders.add(new Order(rs.getInt("id_narudzba"), rs.getString("narucio"), rs.getString("adresa"), rs.getString("datum_narudzbe"), rs.getString("dodatne_biljeske"), rs.getInt("status_id_status")));
			}
			return listOfOrders;
		} catch (SQLException e) {
			Logger.getLogger(DbOrderImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
}
