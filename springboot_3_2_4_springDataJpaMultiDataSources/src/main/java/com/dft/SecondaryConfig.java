package com.dft;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Class Name PrimaryConfig
 * @Author dongfuting
 * @Create In 2018年03月19日 21:48
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySecondary",
    transactionManagerRef = "transactionManagerSecondary",
    basePackages = {"com.dft.domain.s"}) // 设置Repository所在位置
public class SecondaryConfig {

  @Autowired
  @Qualifier("secondaryDataSource")
  private DataSource secondaryDataSource;

  @Bean(name = "entityManagerSecondary")
  public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
    return entityManagerFactorySecondary(builder).getObject().createEntityManager();
  }

  @Bean(name = "entityManagerFactorySecondary")
  public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(
      EntityManagerFactoryBuilder builder) {
    return builder.dataSource(secondaryDataSource).properties(getVendorProperties(secondaryDataSource))
        .packages("com.dft.domain.s").persistenceUnit("SecondaryPersistenceUnit").build();
  }

  @Autowired
  private JpaProperties jpaProperties;

  private Map<String, String> getVendorProperties(DataSource dataSource) {
    return jpaProperties.getHibernateProperties(dataSource);
  }

  @Bean(name = "transactionManagerSecondary")
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
    return new JpaTransactionManager((entityManagerFactorySecondary(builder).getObject()));
  }

}
