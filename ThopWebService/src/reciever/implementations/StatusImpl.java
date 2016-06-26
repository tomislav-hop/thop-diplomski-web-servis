package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.Status;
import reciever.interfaces.StatusInterface;

public class StatusImpl implements StatusInterface {

	@Override
	public String addStatus(String json) {
		System.out.println("Recieved: " + json);

		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();

		Gson gson = new GsonBuilder().create();
		Status s = gson.fromJson(json, Status.class);

		mySQL.addStatus(s);
		mySQL.closeDatabaseConnection();

		return null;
	}

	@Override
	public String getStatus(String statusId) {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		Status s = mySQL.getStatus(statusId);
		String returnJson = new Gson().toJson(s);
		mySQL.closeDatabaseConnection();
		return returnJson;
	}

	@Override
	public String getAllStatuses() {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		List<Status> listOfStatuses = mySQL.getAllStatuses();
		mySQL.closeDatabaseConnection();
		String returnJson = new Gson().toJson(listOfStatuses);
		return returnJson;
	}

}
