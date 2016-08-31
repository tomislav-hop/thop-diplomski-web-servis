package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.Order;
import reciever.interfaces.OrderInterface;
import start.Start;

public class OrderImpl implements OrderInterface {

	@Override
	public String addOrder(String json) {
		Gson gson = new GsonBuilder().create();
		Order o = gson.fromJson(json, Order.class);
		String response = Start.mySQLConnectionHelper.addOrder(o);
		return response;
	}

	@Override
	public String getOrder(String orderId) {
		Order o = Start.mySQLConnectionHelper.getOrder(orderId);
		String returnJson = new Gson().toJson(o);
		return returnJson;
	}

	@Override
	public String getAllOrders(String userId) {
		List<Order> listOfOrderss = Start.mySQLConnectionHelper.getAllOrders(userId);
		String returnJson = new Gson().toJson(listOfOrderss);
		return returnJson;
	}

}
