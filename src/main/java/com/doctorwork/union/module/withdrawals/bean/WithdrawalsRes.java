package com.doctorwork.union.module.withdrawals.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class WithdrawalsRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Long withdrawalsDate;

    private BigDecimal withdrawalsMoney;

    private BigDecimal serviceMoney;

    private BigDecimal personalIncomeTaxMoney;

    private BigDecimal arrivalMoney;

    private BigDecimal balance;

    private Integer status;

    private String reason;

    private Long createTime;

    private Long modifyTime;

    private Integer isDelete;

    private String doctorId;

    private String passportId;

    private String doctorName;

    private String checkBatch;
}