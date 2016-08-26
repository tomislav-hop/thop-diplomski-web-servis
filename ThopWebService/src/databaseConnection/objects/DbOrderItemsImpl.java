package databaseConnection.objects;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.OrderItems;

public class DbOrderItemsImpl {

	public String addOrderItems(OrderItems[] orderItems, String orderId, Connection conn) {

		try {
			Statement stmt = conn.createStatement();

			for (OrderItems orderItem : orderItems) {
				String sql = "INSERT INTO orderItems VALUES (NULL, " + orderItem.getId_item() + ", '" + orderItem.getDeadline() + "', " + orderItem.getWeight() + ", '" + orderItem.getStartTime() + "', " + orderItem.getDelivery() + ", " + orderItem.getCool() + ", " + orderItem.getCut() + ", " + orderItem.getId_package() + ", '" + orderItem.getAdditionalNotes() + "', '" + orderItem.getDeliveryTime() + "', " + orderId + ");";
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

}
