package com.synex.controller;

import com.synex.domain.Address;
import com.synex.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{addressId}")
    public Optional<Address> getAddressById(@PathVariable Long addressId) {
        return addressService.getAddressById(addressId);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping("/saveAddress")
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

   
}
