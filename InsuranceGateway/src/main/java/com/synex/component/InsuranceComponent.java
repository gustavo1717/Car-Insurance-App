package com.synex.component;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InsuranceComponent {
	
	public JsonNode saveDriver(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveDriver", request, Object.class);
	    Object objects = responseEntity.getBody();
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    return returnObj;
	}
	
	public JsonNode savePolicy(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/savePolicy", request, Object.class);
	    Object objects = responseEntity.getBody();
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    return returnObj;
	}
	
	public JsonNode saveInsured(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveInsured", request, Object.class);
	    Object objects = responseEntity.getBody();
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    return returnObj;
	}
	
	public JsonNode saveAddress(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveAddress", request, Object.class);
	    Object objects = responseEntity.getBody();
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    return returnObj;
	}
	
	public JsonNode saveVehicle(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveVehicle", request, Object.class);
	    Object objects = responseEntity.getBody();
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    return returnObj;
	}
	
	public JsonNode saveDocument(JsonNode json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/upload", request, Object.class);
        Object objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
        return returnObj;
    }
	
	public List<JsonNode> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> bookingObj = restTemplate.getForEntity("http://localhost:8383/autoPlan", JsonNode.class);

        System.out.println(bookingObj);

        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> node = mapper.convertValue(bookingObj.getBody(), List.class);
        return node;
    }
	
	public List<JsonNode> findAllPolicies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> bookingObj = restTemplate.getForEntity("http://localhost:8383/policies", JsonNode.class);

        System.out.println(bookingObj);

        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> node = mapper.convertValue(bookingObj.getBody(), List.class);
        return node;
    }

}
