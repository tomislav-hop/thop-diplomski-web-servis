package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.OrderItems;
import gsonObjects.Status;

public class DbOrderItemsImpl {

	public String addOrderItems(OrderItems[] orderItems, String orderId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			for (OrderItems orderItem : orderItems) {
				String sql = "INSERT INTO orderItems VALUES (NULL, " + orderItem.getId_item() + ", '" + orderItem.getDeadline() + "', " + orderItem.getWeight() + ", '" + orderItem.getStartTime() + "', " + orderItem.getDelivery() + ", " + orderItem.getCool() + ", " + orderItem.getCut() + ", " + orderItem.getId_package() + ", '" + orderItem.getAdditionalNotes() + "', '" + orderItem.getDeliveryTime() + "', " + orderId + ", " + orderItem.getAmount() + ");";
				System.out.println("SQL: " + sql);
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			}
			System.out.println("Successfully added " + orderItems.length + " items to order with id " + orderId);
			return "Successfully added " + orderItems.length + " items to order with id " + orderId;
		} catch (SQLException ex) {
			Logger.getLogger(DbOrderImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "OrderItems add failed: " + ex.toString();
		}
	}

	public OrderItems getOrderItem(String orderItemId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM orderitems WHERE id_orderItems = " + orderItemId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			OrderItems returnOrderItem = null;
			while (rs.next()) {
				returnOrderItem = new OrderItems(rs.getInt("id_orderItems"), rs.getInt("id_item"), rs.getString("deadline"), rs.getDouble("weight"), rs.getString("startTime"), rs.getInt("delivery"), rs.getInt("cool"), rs.getInt("cut"), rs.getInt("id_package"), rs.getString("additionalNotes"), rs.getString("deliveryTime"), rs.getInt("id_order"), rs.getInt("amount"));
			}
			return returnOrderItem;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderItems> getAllItemsFromOrder(Connection conn, String orderId) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM orderitems WHERE id_order = " + orderId + ";";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<OrderItems> listOfItems = new ArrayList<>();
			while (rs.next()) {
				listOfItems.add(new OrderItems(rs.getInt("id_orderItems"), rs.getInt("id_item"), rs.getString("deadline"), rs.getDouble("weight"), rs.getString("startTime"), rs.getInt("delivery"), rs.getInt("cool"), rs.getInt("cut"), rs.getInt("id_package"), rs.getString("additionalNotes"), rs.getString("deliveryTime"), rs.getInt("id_order"), rs.getInt("amount")));
			}
			return listOfItems;
		} catch (SQLException e) {
			Logger.getLogger(DbStatusImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

}
