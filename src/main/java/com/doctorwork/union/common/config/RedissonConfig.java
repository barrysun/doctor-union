package com.doctorwork.union.common.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.spring.session.config.EnableRedissonHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.session.web.http.DefaultCookieSerializer;


//@Configuration
//@ConditionalOnClass(Config.class)
@EnableRedissonHttpSession(maxInactiveIntervalInSeconds = Integer.MAX_VALUE, keyPrefix = "doctor-union")
@EnableConfigurationProperties(RedisProperties.class)
//@Getter
//@Setter
//@AutoConfigureBefore(RedissonHttpSessionConfiguration.class)
public class RedissonConfig {


    @Autowired
    private RedisProperties redisProperties;
    
    @Bean
    public RedissonClient redisson() throws InstantiationException, IllegalAccessException, ClassNotFoundException, LinkageError {
        Config config = new Config();
        System.out.println("redisProperties===>"+ JSON.toJSONString(redisProperties));

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.setSerializationInclusion(Include.NON_NULL);
        om.constructType(Object.class);
        JsonJacksonCodec jacksonCodec = new JsonJacksonCodec(om);

        config.setCodec(jacksonCodec);

        config.useSentinelServers()
              .setMasterName(redisProperties.getMasterName())
              .addSentinelAddress(redisProperties.getSentinelAddress().split(","))
              .setPassword(redisProperties.getPassword())
              .setDatabase(redisProperties.getDatabase())
              .setConnectTimeout(redisProperties.getConnectionTimeout())
              .setMasterConnectionPoolSize(redisProperties.getMasterConnectionPoolSize())
              .setMasterConnectionMinimumIdleSize(redisProperties.getMasterConnectionMinimumIdleSize())
              .setRetryAttempts(redisProperties.getRetryAttempts())
              .setRetryInterval(redisProperties.getRetryInterval());

        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    @Bean
    public DefaultCookieSerializer defaultCookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookiePath("/");
        defaultCookieSerializer.setCookieName(redisProperties.getApplicationName() + "_session_id");
        return defaultCookieSerializer;
    }
//
    @Bean
    public RedisHttpSessionConfiguration redisHttpSessionConfiguration(
            DefaultCookieSerializer defaultCookieSerializer) {
        RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
        redisHttpSessionConfiguration.setCookieSerializer(defaultCookieSerializer);
        redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(604800);
        redisHttpSessionConfiguration.setRedisNamespace(redisProperties.getApplicationName());
        return redisHttpSessionConfiguration;
    }
}
