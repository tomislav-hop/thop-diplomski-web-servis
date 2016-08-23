package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gsonObjects.Package;

public class DbPackageImpl {
	public String addPackage(Package Package, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO package VALUES (NULL, '" + Package.getPackageName() + "', '" + Package.getPackageDescription() + "');";
			System.out.println("SQL: " + sql);
			stmt.executeUpdate(sql);
			System.out.println("Package successfully added.");
			return "Package successfully added.";
		} catch (SQLException ex) {
			Logger.getLogger(DbPackageImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Package add failed: " + ex.toString();
		}
	}

	public List<Package> getAllPackages(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM package;";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<Package> listOfPackages = new ArrayList<>();
			while (rs.next()) {
				listOfPackages.add(new Package(rs.getInt("id_package"), rs.getString("name"), rs.getString("desc")));
			}
			return listOfPackages;
		} catch (SQLException e) {
			Logger.getLogger(DbPackageImpl.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public Package getPackage(String PackageId, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM package WHERE id_package = " + PackageId + ";";
			ResultSet rs = stmt.executeQuery(sql);
			Package returnPackage = null;
			while (rs.next()) {
				returnPackage = new Package(rs.getInt("id_package"), rs.getString("name"), rs.getString("desc"));
			}
			return returnPackage;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
