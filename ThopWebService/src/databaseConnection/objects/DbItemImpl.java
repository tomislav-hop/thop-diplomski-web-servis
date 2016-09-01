package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.Item;

public class DbItemImpl {

	public String addItem(Item item, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO item VALUES (NULL, '" + item.getItemName() + "', '" + item.getItemDescription() + "', '" + item.getItemTimePerKg() + "');";
			System.out.println("SQL: " + sql);
			stmt.executeUpdate(sql);
			System.out.println("Item successfully added.");
			return "Item successfully added.";
		} catch (SQLException ex) {
			Logger.getLogger(DbItemImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Item add failed: " + ex.toString();
		}
	}

	public List<Item> getAllItems(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM item;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Item> listOfItems = new ArrayList<>();
			while (rs.next()) {
				listOfItems.add(new Item(rs.getInt("id_item"), rs.getString("name"), rs.getString("desc"), rs.getDouble("timePerKg")));
			}
			return listOfItems;
		} catch (SQLException e) {
			Logger.getLogger(DbItemImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public Item getItem(String itemId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM item WHERE id_item = " + itemId + ";";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			Item returnItem = null;
			while (rs.next()) {
				returnItem = new Item(rs.getInt("id_item"), rs.getString("name"), rs.getString("desc"), rs.getDouble("timePerKg"));
			}
			return returnItem;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public double getBakeTime(String itemId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM item WHERE id_item = " + itemId + ";";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			Double returnBakeTime = null;
			while (rs.next()) {
				returnBakeTime = rs.getDouble("timePerKg");
			}
			return returnBakeTime;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
