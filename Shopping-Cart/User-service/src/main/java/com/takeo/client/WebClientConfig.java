package com.takeo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
     private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient cartWebClinet(){
        return WebClient.builder()
                .baseUrl("http://cart-service")
                .filter(filterFunction)
                .build();
    }
    @Bean
    public CartClient cartClient(){
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(cartWebClinet()))
                .build();
        return httpServiceProxyFactory.createClient(CartClient.class);

    }
}
