package com.vincent.mongock;

import com.vincent.mongock.config.ApplicationConfig;
import com.vincent.mongock.config.MongoDbCommonConfig;
import com.vincent.mongock.config.MongockConfig;
import io.mongock.api.annotations.MongockCliConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({
        ApplicationConfig.class, // not loaded in the CLI
        MongoDbCommonConfig.class,
        MongockConfig.class})
@MongockCliConfiguration(sources = {MongoDbCommonConfig.class, MongockConfig.class})
public class MongockApplication {

    public static final String CLIENTS_COLLECTION_NAME = "clientCollection";
    public static final String PRODUCTS_COLLECTION_NAME = "productCollection";

    public static void main(String[] args) {
        SpringApplication.run(MongockApplication.class, args);
    }
}
