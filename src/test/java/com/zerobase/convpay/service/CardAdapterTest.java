package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.*;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

class CardAdapterTest {

    CardAdapter cardAdapter = new CardAdapter();

    @Test
    public void capture_success() throws Exception {
        //given
        Integer payAmount = 99;

        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        //then
        assertEquals(CardUseResult.USE_SUCCESS, cardUseResult);
    }

    @Test
    public void capture_fail() throws Exception {
        //given
        Integer payAmount = 101;

        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        //then
        assertEquals(CardUseResult.USE_FAIL, cardUseResult);
    }

    @Test
    public void cancelCapture_sucess() throws Exception {
        //given
        Integer payAmount = 1001;

        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(payAmount);

        //then
        assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS, cardUseCancelResult);
    }
}