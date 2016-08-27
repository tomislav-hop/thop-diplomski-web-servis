package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.OrderItems;
import reciever.interfaces.OrderItemsInterface;
import start.Start;

public class OrderItemsImpl implements OrderItemsInterface {

	@Override
	public String addOrderItems(String json, String orderId) {
		Gson gson = new GsonBuilder().create();
		OrderItems[] oi = gson.fromJson(json, OrderItems[].class);
		String response = Start.mySQLConnectionHelper.addOrderItems(oi, orderId);
		return response;
	}

	@Override
	public String getOrderItem(String orderItemId) {
		OrderItems oi = Start.mySQLConnectionHelper.getOrderItem(orderItemId);
		String returnJson = new Gson().toJson(oi);
		return returnJson;
	}

	@Override
	public String getAllOrderItems(String orderId) {
		List<OrderItems> oi = Start.mySQLConnectionHelper.getAllOrderItemsForOrder(orderId);
		String returnJson = new Gson().toJson(oi);
		return returnJson;
	}

}
