package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.synex.service.StripeService;

@RestController
public class PaymentController {
	@Autowired StripeService stripeService;

    @GetMapping("/checkout")
       public String checkout(@RequestParam("amount") Integer amount) {
           String clientSecret = null;
           try {
               clientSecret = stripeService.createPaymentIntent(amount);
           } catch (StripeException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           } // 1000 represents the payment amount in cents
           return clientSecret; // The name of your JSP page
       }

   @PostMapping("/process-payment")
   public String processPayment(@RequestParam("paymentMethodId") String paymentMethodId,
                                @RequestParam("clientSecret") String clientSecret,
                                Model model) {
       try {
           stripeService.confirmPaymentIntent(clientSecret, paymentMethodId);
           model.addAttribute("paymentStatus", "Payment successful");
       } catch (StripeException e) {
           model.addAttribute("paymentStatus", "Payment failed: " + e.getMessage());
       }
       return "payment-result"; // The name of your JSP page for showing the payment result
   }
}
