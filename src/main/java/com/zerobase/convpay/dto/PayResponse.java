package com.zerobase.convpay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayResponse {

    // 결제 결과
    PayResult payResult;

    // 성공 금액
    Integer paidAmount;
}
