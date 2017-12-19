package com.doctorwork.union.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("file:config/server.properties")

public class  FileProperties{


}