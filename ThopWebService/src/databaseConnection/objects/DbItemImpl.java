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
			String sql = "INSERT INTO artikl VALUES (NULL, '" + item.getItemName() + "', '" + item.getItemDescription() + "', '" + item.getItemTimePerKg() + "');";
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
			String sql = "SELECT * FROM artikl;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Item> listOfItems = new ArrayList<>();
			while (rs.next()) {
				listOfItems.add(new Item(rs.getInt("id_artikl"), rs.getString("naziv"), rs.getString("opis"), rs.getDouble("vrijeme_po_kg")));
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
			String sql = "SELECT * FROM artikl WHERE id_artikl = " + itemId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			Item returnItem = null;
			while (rs.next()) {
				returnItem = new Item(rs.getInt("id_artikl"), rs.getString("naziv"), rs.getString("opis"), rs.getDouble("vrijeme_po_kg"));
			}
			return returnItem;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
