package com.doctorwork.union.module.passport.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by barry on 2017/10/18.
 */
@Getter
@Setter
public class UserVo implements Serializable {

    @JsonProperty("user_id")
    private Integer userId;

    private List<String> role;

}
