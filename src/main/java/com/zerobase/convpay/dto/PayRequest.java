package com.zerobase.convpay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayRequest {

    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 금액
    Integer payAmount;


}
