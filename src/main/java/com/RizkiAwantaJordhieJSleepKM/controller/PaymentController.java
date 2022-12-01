package com.RizkiAwantaJordhieJSleepKM.controller;

import com.RizkiAwantaJordhieJSleepKM.*;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    @PostMapping("/create")
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int renterId,
                    @RequestParam int roomId,
                    @RequestParam String from,
                    @RequestParam String to
            )
    {
        Account findAccount = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        Room findRoom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        double roomPrice = findRoom.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate;
        Date toDate;
        try {
            fromDate = sdf.parse(from);
            toDate = sdf.parse(to);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (findAccount.balance >= roomPrice && Payment.availability(fromDate, toDate, findRoom)) {
            Payment newPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            findAccount.balance -= roomPrice;
            newPayment.status = Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromDate, toDate, findRoom);
            paymentTable.add(newPayment);
            return newPayment;
        }
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id) {
        Payment findPayment = Algorithm.<Payment>find(getJsonTable(), payment -> payment.id == id);
        if(findPayment.status == Invoice.PaymentStatus.WAITING) {
            findPayment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id) {
        Payment findPayment = Algorithm.<Payment>find(getJsonTable(), payment -> payment.id == id);
        if(findPayment.status == Invoice.PaymentStatus.WAITING) {
            Account findAccount = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == findPayment.buyerId);
            Room findRoom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == findPayment.getRoomId());
            findPayment.status = Invoice.PaymentStatus.FAILED;
            findAccount.balance += findRoom.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(
            @PathVariable int id
    ) {
        return false;
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
}
