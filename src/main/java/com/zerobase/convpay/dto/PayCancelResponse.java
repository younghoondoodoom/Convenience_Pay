package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(of = {"payCancelResult", "payCancelAmount"})
public class PayCancelResponse {

    PayCancelResult payCancelResult;
    Integer payCancelAmount;
}
