package com.bilge.elasticblog.configuration.database;

import com.bilge.elasticblog.configuration.profiles.Profiles;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({Profiles.END_TO_END, Profiles.INTEGRATION_TEST, Profiles.DEV})
public class DatabaseInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
  public static CustomPostgresContainer postgresContainer = new CustomPostgresContainer();

  static {
    postgresContainer.start();
  }

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    TestPropertyValues.of(
      "spring.datasource.url=" + postgresContainer.getJdbcUrl(),
      "spring.datasource.username=" + postgresContainer.getUsername(),
      "spring.datasource.password=" + postgresContainer.getPassword()
    ).applyTo(applicationContext.getEnvironment());
  }
}
