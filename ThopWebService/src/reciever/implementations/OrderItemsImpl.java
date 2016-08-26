package reciever.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.OrderItems;
import reciever.interfaces.OrderItemsInterface;

public class OrderItemsImpl implements OrderItemsInterface {

	@Override
	public String addOrderItems(String json, String orderId) {
		System.out.println("Recieved: " + json);
		Gson gson = new GsonBuilder().create();
		OrderItems[] oi = gson.fromJson(json, OrderItems[].class);
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		String response = mySQL.addOrderItems(oi, orderId);
		mySQL.closeDatabaseConnection();
		return response;
	}

	@Override
	public String getOrderItem(String OrderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllOrderItems(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
