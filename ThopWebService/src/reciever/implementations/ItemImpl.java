package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.ItemGson;
import reciever.interfaces.ItemInterface;

public class ItemImpl implements ItemInterface {

	@Override
	public String addItem(String json) {
		System.out.println("Recieved: " + json);

		Gson gson = new GsonBuilder().create();
		ItemGson ag = gson.fromJson(json, ItemGson.class);

		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		mySQL.addItem(ag);
		mySQL.closeDatabaseConnection();

		return "Recieved: " + json;
	}

	@Override
	public String getItem(String itemId) {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		ItemGson item = mySQL.getItem(itemId);
		String returnJson = new Gson().toJson(item);
		mySQL.closeDatabaseConnection();
		return returnJson;
	}

	@Override
	public String getAllItems() {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		List<ItemGson> listOfItems = mySQL.getAllItems();
		mySQL.closeDatabaseConnection();
		String returnJson = new Gson().toJson(listOfItems);
		return returnJson;
	}

}
