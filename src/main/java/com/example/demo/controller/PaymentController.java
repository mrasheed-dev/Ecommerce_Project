package com.example.demo.controller;


import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(
            PaymentService service) {

        this.service = service;
    }

    @PostMapping("/create-order")
    public String createOrder(

            @RequestParam Integer amount
    ) throws Exception {

        JSONObject order =
                service.createOrder(amount);

        return order.toString();
    }
}
