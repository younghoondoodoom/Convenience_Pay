package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.*;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

class DiscountByConvenienceTest {

    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test

    public void discountTest() throws Exception {
        //given
        PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestGU = new PayRequest(PayMethodType.MONEY, ConvenienceType.GU, 1000);
        PayRequest payRequestSeven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN,
            1000);
        //when
        Integer disCountAmountG25 = discountByConvenience.getDisCountAmount(payRequestG25);
        Integer disCountAmountGU = discountByConvenience.getDisCountAmount(payRequestGU);
        Integer disCountAmountSeven = discountByConvenience.getDisCountAmount(payRequestSeven);

        //then
        assertEquals(800, disCountAmountG25);
        assertEquals(900, disCountAmountGU);
        assertEquals(1000, disCountAmountSeven);
    }
}