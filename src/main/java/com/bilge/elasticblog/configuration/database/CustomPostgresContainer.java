package com.bilge.elasticblog.configuration.database;

import com.bilge.elasticblog.configuration.elastic.CustomElasticContainer;
import org.testcontainers.containers.PostgreSQLContainer;

public class CustomPostgresContainer extends PostgreSQLContainer {

  private final String dbUsername = "test";
  private final String dbPassword = "test";
  private static final String IMAGE_VERSION = "postgres:15.5-alpine";

  public CustomPostgresContainer() {
    super(IMAGE_VERSION);
    withDatabaseName("test");
    withUsername(dbUsername);
    withPassword(dbPassword);
    withExposedPorts(5432);
    withEnv("TZ", "Europe/Istanbul");
    withEnv("LANG", "tr_TR.utf8");
    withEnv("POSTGRES_INITDB_ARGS", "--locale-provider=icu --icu-locale=tr-TR");
  }
}
