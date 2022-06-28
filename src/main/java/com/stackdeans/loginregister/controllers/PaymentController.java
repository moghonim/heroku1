package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.payment.CreatePayment;
import com.stackdeans.loginregister.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public String createPaymentIntent(@RequestBody @Valid CreatePayment createPayment) throws StripeException {
        return paymentService.createPaymentIntent(createPayment);
    }
}
