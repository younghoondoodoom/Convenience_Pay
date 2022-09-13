package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayCancelRequest {

    // 결제 수단
    PayMethodType payMethodType;
    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 취소 금액
    Integer PayCancelAmount;
}
