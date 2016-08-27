package reciever.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.User;
import reciever.interfaces.UserInterface;
import start.Start;

public class UserImpl implements UserInterface {

	@Override
	public String login(String json) {
		Gson gson = new GsonBuilder().create();
		User user = gson.fromJson(json, User.class);
		String response = Start.mySQLConnectionHelper.login(user.getUsername(), user.getPassword());
		return response;
	}

}
