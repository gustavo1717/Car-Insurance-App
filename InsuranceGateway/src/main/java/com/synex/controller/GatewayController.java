package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.component.InsuranceComponent;
import com.synex.component.PaymentComponent;
import com.synex.domain.User;
import com.synex.service.UserService;

@RestController
public class GatewayController {
	
	@Autowired InsuranceComponent insuranceComponent;
	
	@Autowired PaymentComponent paymentComponent;
	
	@Autowired UserService userService;
	
	@RequestMapping(value = "/saveDriver", method = RequestMethod.POST)
	public JsonNode saveDriver(@RequestBody JsonNode json) {
		return insuranceComponent.saveDriver(json);
	}
	
	@RequestMapping(value = "/autoPlan", method = RequestMethod.GET)
	public List<JsonNode> getAllRoomTypes() {
	    return insuranceComponent.findAll();
	}
	
	@RequestMapping(value = "/saveInsured", method = RequestMethod.POST)
	public JsonNode saveInsured(@RequestBody JsonNode json) {
		return insuranceComponent.saveInsured(json);
	}
	
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public JsonNode saveAddress(@RequestBody JsonNode json) {
		return insuranceComponent.saveAddress(json);
	}
	
	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public JsonNode saveVehicle(@RequestBody JsonNode json) {
		return insuranceComponent.saveVehicle(json);
	}
	
	@RequestMapping(value = "/savePolicy", method = RequestMethod.POST)
	public JsonNode savePolicy(@RequestBody JsonNode json) {
		return insuranceComponent.savePolicy(json);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public JsonNode saveDocument(@RequestBody JsonNode json) {
		return insuranceComponent.saveDocument(json);
	}
	
	@PostMapping(value = "/checkout")
	public String checkout(@RequestParam Long amount) {
		return paymentComponent.checkout(amount);
	}
	
	@PostMapping(value= "/user/policyId")
	public Long setPolicyId (@RequestParam String policyId, @RequestParam String username) {
		User user = userService.setPolicyId(Long.valueOf(policyId), username);
		return user.getPolicyId();
	}
	

}
