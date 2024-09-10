package com.bilge.elasticblog.configuration.annotations;

import com.bilge.elasticblog.configuration.database.DatabaseInitializer;
import com.bilge.elasticblog.configuration.profiles.Profiles;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Repository.class))
@ExtendWith(SpringExtension.class)
@EntityScan(basePackages = "com.bilge.elasticblog")
@EnableJpaRepositories(basePackages = "com.bilge.elasticblog")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = DatabaseInitializer.class)
@ActiveProfiles(Profiles.INTEGRATION_TEST)
public @interface DatabaseTest { }
