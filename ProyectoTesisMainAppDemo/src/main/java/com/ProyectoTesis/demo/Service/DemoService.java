package com.ProyectoTesis.demo.Service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DemoService {

	public String requestData(String name) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/demo/requestData/" + name;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri).queryParam("name", name);
		ResponseEntity<String> response = null;
		String answer = null;
		try {
			//response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
			response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
			answer = response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return answer;
	}
	
}
