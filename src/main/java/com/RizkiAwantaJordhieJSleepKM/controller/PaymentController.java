package com.RizkiAwantaJordhieJSleepKM.controller;

import com.RizkiAwantaJordhieJSleepKM.*;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a class for the Payment objects.
 * It provides methods for creating, accepting, canceling, and submitting payments.
 * It also implements the BasicGetController interface to provide basic GET methods.
 *
 * @author Rizki Awanta Jordhie, JSleepKM
 * @version (2 - PT7 - 10/11/2022)
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    /**
     * The table of payments.
     */
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    /**
     * This method maps a POST request to the specified path for creating a Payment object.
     * The request parameters include the IDs of the buyer and renter, the ID of the booked room,
     * and the dates for the booking.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the booked room
     * @param from the start date of the booking
     * @param to the end date of the booking
     * @return the created Payment object, or null if the payment could not be created
     */
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

    /**
     * Accepts a payment with the given ID.
     *
     * @param id the ID of the payment to accept
     * @return `true` if the payment was accepted, or `false` if the payment could not be found or is not in the WAITING state
     */
    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id) {
        Payment findPayment = Algorithm.<Payment>find(getJsonTable(), payment -> payment.id == id);
        if(findPayment.status == Invoice.PaymentStatus.WAITING) {
            findPayment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    /**
     * Cancels a payment with the given ID and refunds the buyer's account.
     *
     * @param id the ID of the payment to cancel
     * @return `true` if the payment was canceled and the buyer's account was refunded, or `false` if the payment could not be found or is not in the WAITING state
     */
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

    /**
     * Submits a payment with the given ID.
     *
     * @param id the ID of the payment to submit
     * @return `false`, as this method currently does nothing
     */
    @PostMapping("/{id}/submit")
    public boolean submit(
            @PathVariable int id
    ) {
        return false;
    }

    /**
     * Returns the table containing payment information.
     *
     * @return the table containing payment information
     */
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
}
