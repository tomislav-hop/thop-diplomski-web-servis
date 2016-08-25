package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.Order;
import reciever.interfaces.OrderInterface;

public class OrderImpl implements OrderInterface {

	@Override
	public String addOrder(String json) {
		System.out.println("Recieved: " + json);
		Gson gson = new GsonBuilder().create();
		Order o = gson.fromJson(json, Order.class);
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		String response = mySQL.addOrder(o);
		mySQL.closeDatabaseConnection();
		return response;
	}

	@Override
	public String getOrder(String orderId) {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		Order o = mySQL.getOrder(orderId);
		String returnJson = new Gson().toJson(o);
		mySQL.closeDatabaseConnection();
		return returnJson;
	}

	@Override
	public String getAllOrders() {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		List<Order> listOfOrderss = mySQL.getAllOrders();
		mySQL.closeDatabaseConnection();
		String returnJson = new Gson().toJson(listOfOrderss);
		return returnJson;
	}

}
