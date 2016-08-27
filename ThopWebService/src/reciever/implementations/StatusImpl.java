package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.Status;
import reciever.interfaces.StatusInterface;
import start.Start;

public class StatusImpl implements StatusInterface {

	@Override
	public String addStatus(String json) {
		Gson gson = new GsonBuilder().create();
		Status s = gson.fromJson(json, Status.class);
		Start.mySQLConnectionHelper.addStatus(s);
		return "Recieved: " + json;
	}

	@Override
	public String getStatus(String statusId) {
		Status s = Start.mySQLConnectionHelper.getStatus(statusId);
		String returnJson = new Gson().toJson(s);
		return returnJson;
	}

	@Override
	public String getAllStatuses() {
		List<Status> listOfStatuses = Start.mySQLConnectionHelper.getAllStatuses();
		String returnJson = new Gson().toJson(listOfStatuses);
		return returnJson;
	}

}
