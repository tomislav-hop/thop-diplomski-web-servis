package reciever.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.Status;
import gsonObjects.User;
import reciever.interfaces.UserInterface;

public class UserImpl implements UserInterface {

	@Override
	public String login(String json) {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		Gson gson = new GsonBuilder().create();
		User user = gson.fromJson(json, User.class);
		String response = mySQL.login(user.getUsername(), user.getPassword());
		mySQL.closeDatabaseConnection();
		return response;
	}

}
