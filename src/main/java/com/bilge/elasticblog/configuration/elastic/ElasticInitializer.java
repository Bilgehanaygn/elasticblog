package com.bilge.elasticblog.configuration.elastic;

import com.bilge.elasticblog.configuration.profiles.Profiles;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({Profiles.END_TO_END, Profiles.INTEGRATION_TEST, Profiles.DEV})
public class ElasticInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  public static CustomElasticContainer elasticContainer = new CustomElasticContainer();

  static { elasticContainer.start(); }

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    TestPropertyValues.of(
      "spring.data.elasticsearch.repositories.enabled=true",
      "spring.elasticsearch.username=" + elasticContainer.getUsername(),
      "spring.elasticsearch.password=" + elasticContainer.getPassword(),
      "spring.elasticsearch.uris=" + elasticContainer.getConnectionUri()
    ).applyTo(applicationContext.getEnvironment());
  }
}
