package reciever.implementations;

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
	public String addOrderItems(String json) {
		System.out.println("Recieved: " + json);
		Gson gson = new GsonBuilder().create();
		//Order o = gson.fromJson(json, Order.class);
		//INSERT INTO stavke_narudzbe VALUES (NULL, '7', '2016-08-10 00:00:00', '45', '2016-08-10 00:00:00', '1', '1', '1', '6', 'sDSAFSFDsdfsdfsdfsfdfs', '2016-08-26 00:00:00');
		//List<OrderItems> oi = gson.fromJson(json, List<OrderItems>.class);
		OrderItems[] oi = gson.fromJson(json, OrderItems[].class);
		
		//JsonParser jsonParser = new JsonParser();
		//JsonArray orderItemsArray = (JsonArray)jsonParser.parse(json);
		
		return null;
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
