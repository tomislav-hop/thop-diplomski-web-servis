package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.Item;
import reciever.interfaces.ItemInterface;
import start.Start;

public class ItemImpl implements ItemInterface {

	@Override
	public String addItem(String json) {
		Gson gson = new GsonBuilder().create();
		Item i = gson.fromJson(json, Item.class);
		Start.mySQLConnectionHelper.addItem(i);
		return "Recieved: " + json;
	}

	@Override
	public String getItem(String itemId) {
		Item item = Start.mySQLConnectionHelper.getItem(itemId);
		String returnJson = new Gson().toJson(item);
		return returnJson;
	}

	@Override
	public String getAllItems() {
		List<Item> listOfItems = Start.mySQLConnectionHelper.getAllItems();
		String returnJson = new Gson().toJson(listOfItems);
		return returnJson;
	}

	@Override
	public String getBakeTime(String kg, String itemId) {
		double bakeTime = Start.mySQLConnectionHelper.getGetBakeTime(itemId);
		if (bakeTime != -1) {
			double fullBakeTime = bakeTime * Integer.parseInt(kg);
			return String.valueOf(fullBakeTime) + " minutes";
		} else {
			return "Error during calculation";
		}
	}

}
