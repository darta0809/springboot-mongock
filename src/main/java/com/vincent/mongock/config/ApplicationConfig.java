package com.vincent.mongock.config;

import com.vincent.mongock.events.MongockFailEventListener;
import com.vincent.mongock.events.MongockStartedEventListener;
import com.vincent.mongock.events.MongockSuccessEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public MongockStartedEventListener mongockStartedEventListener() {
    return new MongockStartedEventListener();
  }

  @Bean
  public MongockSuccessEventListener mongockSuccessEventListener() {
    return new MongockSuccessEventListener();
  }

  @Bean
  public MongockFailEventListener mongockFailEventListener() {
    return new MongockFailEventListener();
  }
}
