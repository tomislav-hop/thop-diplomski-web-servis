package reciever.implementations;

import java.sql.Statement;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import gsonObjects.Order;
import gsonObjects.OrderItems;
import reciever.interfaces.OrderItemsInterface;

public class OrderItemsImpl implements OrderItemsInterface {

	@Override
	public String addOrderItems(String json, String orderId) {
		System.out.println("Recieved: " + json);
		Gson gson = new GsonBuilder().create();
		OrderItems[] oi = gson.fromJson(json, OrderItems[].class);

		for (OrderItems orderItem : oi) {
			String sql = "INSERT INTO orderItems VALUES (NULL, " + orderItem.getId_item() + ", " + orderItem.getDeadline() + ", " + orderItem.getWeight() + ", " + orderItem.getStartTime() + ", " + orderItem.getDelivery() + ", " + orderItem.getCool() + ", " + orderItem.getCut() + ", " + orderItem.getId_package() + ", " + orderItem.getAdditionalNotes() + ", " + orderItem.getDeliveryTime() + ", " + orderId + ");";
			
			
			
			
			System.out.println("SQL: " + sql);
		}

		return "Test";
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
