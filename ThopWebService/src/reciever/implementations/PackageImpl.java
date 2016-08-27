package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonObjects.Package;
import reciever.interfaces.PackageInterface;
import start.Start;

public class PackageImpl implements PackageInterface {

	@Override
	public String addPackage(String json) {
		Gson gson = new GsonBuilder().create();
		Package p = gson.fromJson(json, Package.class);
		Start.mySQLConnectionHelper.addPackage(p);
		return "Recieved: " + json;
	}

	@Override
	public String getPackage(String packageId) {
		Package p = Start.mySQLConnectionHelper.getPackage(packageId);
		String returnJson = new Gson().toJson(p);
		return returnJson;
	}

	@Override
	public String getAllPackages() {
		List<Package> listOfPackages = Start.mySQLConnectionHelper.getAllPackages();
		String returnJson = new Gson().toJson(listOfPackages);
		return returnJson;
	}

}
