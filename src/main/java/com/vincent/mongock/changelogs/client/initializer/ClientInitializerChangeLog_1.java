package com.vincent.mongock.changelogs.client.initializer;

import static com.vincent.mongock.MongockApplication.CLIENTS_COLLECTION_NAME;

import com.vincent.mongock.model.clients.Client_1;
import com.vincent.mongock.repositories.ClientRepository_1;
import io.mongock.api.annotations.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "client-initializer", order = "1", author = "vincent", systemVersion = "1")
public class ClientInitializerChangeLog_1 {

    public static final int INITIAL_CLIENTS = 10;

    @BeforeExecution
    public void beforeExecution(MongoTemplate mongoTemplate) {
        mongoTemplate.createCollection(CLIENTS_COLLECTION_NAME);
    }

    @RollbackBeforeExecution
    public void rollbackBeforeExecution(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(CLIENTS_COLLECTION_NAME);
    }

    @Execution
    public void execution(ClientRepository_1 clientRepository_1, MongoTemplate mongoTemplate) {
        clientRepository_1.saveAll(
                IntStream.range(0, INITIAL_CLIENTS)
                        .mapToObj(ClientInitializerChangeLog_1::getClient)
                        .collect(Collectors.toList())
        );
    }

    @RollbackExecution
    public void rollbackExecution(ClientRepository_1 clientRepository_1) {
        clientRepository_1.deleteAll();
    }

    private static Client_1 getClient(int i) {
        return new Client_1("name-" + i, 20 + i, "email-" + i, "phone" + i, "country" + i);
    }
}
