package com.vincent.mongock.changelogs.client.updater;

import com.vincent.mongock.model.clients.Client;
import com.vincent.mongock.MongockApplication;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "client-updater-runalways", order = "3", author = "vincent", runAlways = true)
public class ClientUpdaterRunAlwaysChangeLog {

  @Execution
  public void execution(MongoTemplate mongoTemplate) {

    mongoTemplate.findAll(Client.class, MongockApplication.CLIENTS_COLLECTION_NAME)
        .stream()
        .map(client -> client.setCounter(client.getCounter() + 1))
        .forEach(client -> mongoTemplate.save(client, MongockApplication.CLIENTS_COLLECTION_NAME));
  }

  @RollbackExecution
  public void rollbackExecution(MongoTemplate mongoTemplate) {

    mongoTemplate.findAll(Client.class, MongockApplication.CLIENTS_COLLECTION_NAME)
        .stream()
        .map(client -> client.setCounter(client.getCounter() - 1))
        .forEach(client -> mongoTemplate.save(client, MongockApplication.CLIENTS_COLLECTION_NAME));
  }
}
