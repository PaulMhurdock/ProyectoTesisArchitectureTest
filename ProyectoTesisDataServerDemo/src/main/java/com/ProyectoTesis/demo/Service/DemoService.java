package com.ProyectoTesis.demo.Service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DemoService {

	public String extractData(String name) {
		return "DATOS DE CAMPO AGRICOLA DE " + name;
	}
	
	public void sendData(String name) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/demoMainApp/receiveData/" + name;
		//UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri).queryParam("data", "Data para " + name);
		ResponseEntity<String> response = null;
		try {
			//response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, JsonNode.class);
			response = restTemplate.exchange(uri, HttpMethod.POST, null, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
