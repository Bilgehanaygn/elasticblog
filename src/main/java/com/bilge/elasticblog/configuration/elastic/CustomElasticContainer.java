package com.bilge.elasticblog.configuration.elastic;

import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.utility.DockerImageName;


public class CustomElasticContainer extends ElasticsearchContainer {

  private final String username = "elastic";
  private final String password = "elastic_pass";

  public CustomElasticContainer() {
    super(DockerImageName.parse("elasticsearch:8.11.3"));
    addExposedPort(9200);
    withEnv("xpack.security.enabled", "false");
    withEnv("ELASTICSEARCH_PASSWORD", password);
    withEnv("CLUSTER_NAME", "sample-cluster");
    start();
  }

  public String getConnectionUri() {
    return "http://" + getHost() + ":" + getMappedPort(9200);
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }
}

