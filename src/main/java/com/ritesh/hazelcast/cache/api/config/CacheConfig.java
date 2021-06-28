package com.ritesh.hazelcast.cache.api.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Config configure() {

        return new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig().setName("userCache"));
    }


}
