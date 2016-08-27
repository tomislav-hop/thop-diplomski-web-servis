package databaseConnection.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUserImpl {

	public String login(String username, String password, Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password ='" + password + "';";
			System.out.println("SQL: " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				System.out.println("No user");
				return "Fail";
			} else {
				System.out.println("User exist");
				return "Ok";
			}
		} catch (SQLException ex) {
			Logger.getLogger(DbUserImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "User check failed: " + ex.toString();
		}
	}

}
