package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(of = {"payResult", "paidAmount"})

public class PayResponse {

    // 결제 결과
    PayResult payResult;

    // 성공 금액
    Integer paidAmount;
}
