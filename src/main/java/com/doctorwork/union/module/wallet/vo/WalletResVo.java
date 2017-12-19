package com.doctorwork.union.module.wallet.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhengxingle on 2017/10/23.
 */
@Getter
@Setter
public class WalletResVo implements Serializable{

    @JsonProperty("user_id")
    private Integer userId;
    private Long amount;
    @JsonProperty("freeze_amount")
    private Long freezeAmount;
}
