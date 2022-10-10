package com.vincent.mongock.config;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.context.annotation.Configuration;

@EnableMongock
@Configuration
public class MongockConfig {

  //  @Bean
//  public MongockInitializingBeanRunner initializingBeanRunner(
//      RunnerSpringbootBuilder runnerBuilder) {
//    // Runner
//    return runnerBuilder.buildInitializingBeanRunner();
//  }
//
//  /**
//   * The Mongock CLI requires the RunnerBuilder bean
//   */
//  @Bean
//  public RunnerSpringbootBuilder runnerBuilder(ApplicationContext springContext,
//      ApplicationEventPublisher eventPublisher,
//      MongoTemplate mongoTemplate,
//      MongoTransactionManager mongoTransactionManager) {
//    // Driver
//    SpringDataMongoV3Driver driver = SpringDataMongoV3Driver.withDefaultLock(mongoTemplate);
//    driver.enableTransactionWithTxManager(mongoTransactionManager);
//
//    return MongockSpringboot.builder()
//        .setDriver(driver)
//        .addMigrationScanPackage("io.mongock.examples.changelogs")
//        .setSpringContext(springContext)
//        .setEventPublisher(eventPublisher)
//        .setTrackIgnored(true)
//        .setTransactionEnabled(true);
//  }
}
