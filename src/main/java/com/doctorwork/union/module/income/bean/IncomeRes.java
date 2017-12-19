package com.doctorwork.union.module.income.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class IncomeRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String serialNumber;

    private Long incomeDate;

    private String payAccount;

    private String clinicId;

    private BigDecimal payMoney;

    private BigDecimal serviceMoney;

    private BigDecimal platformMoney;

    private BigDecimal incomonMoney;

    private BigDecimal balance;

    private Integer isDelete;

    private Long createTime;

    private Long modifyTime;

    private String passportId;

    private String clinicName;

}