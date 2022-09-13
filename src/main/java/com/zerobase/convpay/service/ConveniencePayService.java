package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import com.zerobase.convpay.type.PaymentResult;

public class ConveniencePayService {

    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    private final DiscountInterface discountInterface = new DiscountByPayMethod();
//    private final DiscountInterface discountInterface = new DiscountByConvenience();

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer disCountAmount = discountInterface.getDisCountAmount(
            payRequest);

        PaymentResult payment = paymentInterface.payment(disCountAmount);

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        return new PayResponse(PayResult.SUCCESS, disCountAmount);

    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(
            payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
            payCancelRequest.getPayCancelAmount());
    }
}
