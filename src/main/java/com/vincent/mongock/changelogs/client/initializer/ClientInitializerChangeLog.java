package com.vincent.mongock.changelogs.client.initializer;

import static com.vincent.mongock.MongockApplication.CLIENTS_COLLECTION_NAME;

import com.vincent.mongock.model.clients.Client;
import com.vincent.mongock.repositories.ClientRepository;
import io.mongock.api.annotations.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "client-initializer", order = "1", author = "vincent")
public class ClientInitializerChangeLog {

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
    public void execution(ClientRepository clientRepository, MongoTemplate mongoTemplate) {
        clientRepository.saveAll(
                IntStream.range(0, INITIAL_CLIENTS)
                        .mapToObj(ClientInitializerChangeLog::getClient)
                        .collect(Collectors.toList())
        );
    }

    @RollbackExecution
    public void rollbackExecution(ClientRepository clientRepository) {
        clientRepository.deleteAll();
    }

    private static Client getClient(int i) {
        return new Client("name-" + i, "email-" + i, "phone" + i, "country" + i);
    }
}
