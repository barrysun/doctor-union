package com.doctorwork.union;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@MapperScan(
        basePackages = {
                "com.doctorwork.union.module.admin.dao",
                "com.doctorwork.union.module.agent.dao",
                "com.doctorwork.union.module.doctor.dao",
                "com.doctorwork.union.module.invitation.dao",
                "com.doctorwork.union.module.order.dao",
                "com.doctorwork.union.module.visit.dao",
                "com.doctorwork.union.module.income.dao",
                "com.doctorwork.union.module.withdrawals.dao"
        }
)
@EnableTransactionManagement
@EnableWebMvc
public class Application{
    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate customRestTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);

        return new RestTemplate(httpRequestFactory);
    }


    public static void main(String[] args){
//        SpringApplication application=new SpringApplication(Application.class);
//        application.run(args);
        SpringApplication.run(Application.class,args);
    }

}