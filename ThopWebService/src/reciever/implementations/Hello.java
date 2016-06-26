package reciever.implementations;

import reciever.interfaces.InterfaceHello;

public class Hello implements InterfaceHello {

	@Override
	public String sayHello(String name) {

		System.out.println("Hello: " + name);
		return "Hello: " + name;
	}

	@Override
	public String testPost(String json) {
		System.out.println("Recieved: " + json);
		return "Recieved: " + json;
	}

}
