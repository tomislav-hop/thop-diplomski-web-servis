package start;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import databaseConnection.MySQLConnectionHelper;

@Singleton
@Startup
public class Start {
	
	public static String limiter = "================================================================================";
	public static MySQLConnectionHelper mySQLConnectionHelper;

	public void startMethod() {
		mySQLConnectionHelper = new MySQLConnectionHelper();
		mySQLConnectionHelper.connectToDatabase();
	}
	
	public void endMethod(){
		mySQLConnectionHelper.closeDatabaseConnection();
	}

}
