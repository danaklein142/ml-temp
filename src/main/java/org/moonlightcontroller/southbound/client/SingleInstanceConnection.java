package org.moonlightcontroller.southbound.client;

import org.moonlightcontroller.managers.models.messages.IMessage;

public class SingleInstanceConnection implements ISingleInstanceConnection {

//	Client client = Client.create();
	String getUrl = "http://localhost:8080/JAXRS-JSON/rest/student/data/get";
	String postUrl = "http://localhost:8080/JAXRS-JSON/rest/student/data/post";

	// an example will be removed
	public void getRequest(){
		/*
		WebResource webResource = client.resource(getUrl);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		
		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);
		*/
	}
	
	// an example will be removed
	public void postRequest(){
		/*
		WebResource webResource = client.resource(postUrl);
		String inputData = "{\"firstName\":\"Alice\",\"lastName\":\"Brown\",\"school\":\"Bright Stars\",\"standard\":\"Three\",\"rollNumber\":1212}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,inputData);
		if(response.getStatus()!=201){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		
		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);
		*/
	}

	@Override
	public void sendMessage(IMessage msg) {
		// TODO Auto-generated method stub

	}
}