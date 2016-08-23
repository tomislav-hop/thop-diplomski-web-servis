package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.Status;

public class DbStatusImpl {

	public String addStatus(Status status, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO status VALUES (NULL, '" + status.getStatusName() + "', '" + status.getStatusDescription() + "');";
			System.out.println("SQL: " + sql);
			stmt.executeUpdate(sql);
			System.out.println("Status successfully added.");
			return "Status successfully added.";
		} catch (SQLException ex) {
			Logger.getLogger(DbStatusImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Status add failed: " + ex.toString();
		}
	}

	public List<Status> getAllStatuses(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM status;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Status> listOfStatuses = new ArrayList<>();
			while (rs.next()) {
				listOfStatuses.add(new Status(rs.getInt("id_status"), rs.getString("name"), rs.getString("desc")));
			}
			return listOfStatuses;
		} catch (SQLException e) {
			Logger.getLogger(DbStatusImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public Status getStatus(String StatusId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM status WHERE id_status = " + StatusId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			Status returnStatus = null;
			while (rs.next()) {
				returnStatus = new Status(rs.getInt("id_status"), rs.getString("name"), rs.getString("desc"));
			}
			return returnStatus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
