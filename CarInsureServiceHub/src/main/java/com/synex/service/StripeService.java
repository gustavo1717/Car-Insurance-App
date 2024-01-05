package com.synex.service;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.annotation.PostConstruct;

@Service
public class StripeService {
    @Value("${stripe.secret-key}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public String createPaymentIntent(int amount) throws StripeException {
        PaymentIntent paymentIntent = PaymentIntent.create(new PaymentIntentCreateParams.Builder()
                .setAmount((long) amount)
                .setCurrency("usd")
                .build());
        return paymentIntent.getClientSecret();
    }

    public void confirmPaymentIntent(String clientSecret, String paymentMethodId) throws StripeException {
        PaymentIntent paymentIntent = PaymentIntent.retrieve(clientSecret);
        paymentIntent.confirm(PaymentIntentConfirmParams.builder().setPaymentMethod(paymentMethodId).build());
    }

}