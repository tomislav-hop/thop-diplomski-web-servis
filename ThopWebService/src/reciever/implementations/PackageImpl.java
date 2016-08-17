package reciever.implementations;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import databaseConnection.MySQLConnectionHelper;
import gsonObjects.Package;
import reciever.interfaces.PackageInterface;

public class PackageImpl implements PackageInterface {

	@Override
	public String addPackage(String json) {
		System.out.println("Recieved: " + json);
		Gson gson = new GsonBuilder().create();
		Package p = gson.fromJson(json, Package.class);
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		mySQL.addPackage(p);
		mySQL.closeDatabaseConnection();
		return "Recieved: " + json;
	}

	@Override
	public String getPackage(String packageId) {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		Package p = mySQL.getPackage(packageId);
		String returnJson = new Gson().toJson(p);
		mySQL.closeDatabaseConnection();
		return returnJson;
	}

	@Override
	public String getAllPackages() {
		MySQLConnectionHelper mySQL = new MySQLConnectionHelper();
		mySQL.connectToDatabase();
		List<Package> listOfPackages = mySQL.getAllPackages();
		mySQL.closeDatabaseConnection();
		String returnJson = new Gson().toJson(listOfPackages);
		return returnJson;
	}

}
