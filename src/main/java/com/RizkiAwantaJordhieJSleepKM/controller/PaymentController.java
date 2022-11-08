package com.RizkiAwantaJordhieJSleepKM.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.Payment;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    @JsonAutowired(filepath = "json/Payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;
    public JsonTable<Payment> getJsonTable() {

        return paymentTable;

    }
    @PostMapping("/create")
    Payment create(@RequestParam int buyerId,
                   @RequestParam int renterId,
                   @RequestParam int roomIid,
                   @RequestParam String from,
                   @RequestParam String to) {

        return null;
    }
    
}
