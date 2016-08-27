package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.Order;
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
    public String getOrderItem(String orderItemId) {
    	MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		OrderItems oi = mySQL.getOrderItem(orderItemId);
		String returnJson = new Gson().toJson(oi);
		mySQL.closeDatabaseConnection();
		return returnJson;
    }

    @Override
    public String getAllOrderItems(String orderId) {
	MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
	mySQL.connectToDatabase();
	List<OrderItems> oi = mySQL.getAllOrderItemsForOrder(orderId);
	String returnJson = new Gson().toJson(oi);
	mySQL.closeDatabaseConnection();
	return returnJson;
    }

}
