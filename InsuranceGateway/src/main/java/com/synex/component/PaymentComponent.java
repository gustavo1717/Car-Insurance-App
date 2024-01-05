package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentComponent {
    public String checkout(long amount) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8383/checkout?amount="+amount, String.class);
        System.out.println(res);
        return res.getBody();
    }

    public String confirm(String clientSecret) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8383/process-payment?clientSecret="+clientSecret, String.class);

        return res.getBody();
    }
}