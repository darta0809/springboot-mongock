package com.vincent.mongock.model.clients;

import com.vincent.mongock.MongockApplication;
import com.vincent.mongock.model.ActivationModel;
import java.time.ZonedDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = MongockApplication.CLIENTS_COLLECTION_NAME)
@CompoundIndexes({
    @CompoundIndex(def = "{'name':1, 'deleted':1}", name = "user_name_idx"),
    @CompoundIndex(def = "{'age':1, 'deleted':1}", name = "user_age_idx"),
    @CompoundIndex(def = "{'email':1, 'deleted':1}", name = "user_email_idx"),
    @CompoundIndex(def = "{'phone':1, 'deleted':1}", name = "user_phone_idx"),
    @CompoundIndex(def = "{'country':1, 'deleted':1, 'activation.status':1}", name = "user_country_activation_idx")
})
@Data
public class Client_1 {

  @Id
  private String id;

  @Field
  private ZonedDateTime dateTime;

  @Field("name")
  private String name;

  @Field("age")
  private int age;

  @Field("email")
  private String email;

  @Field("phone")
  private String phone;

  @Field("country")
  private String country;

  @Field("activation")
  private ActivationModel activation;

  @Field("deleted")
  private boolean deleted;

  @Field("counter")
  private int counter;

  public Client_1() {
    this.dateTime = ZonedDateTime.now();
  }

  public Client_1(String name, int age, String email, String phone, String country) {
    this(name, age, email, phone, country, new ActivationModel());
  }

  public Client_1(String name, int age, String email, String phone, String country,
      ActivationModel activationModel) {
    this();
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.country = country;
    this.activation = activation;
    this.deleted = false;
    this.counter = 0;
  }

  public Client_1 setId(String id) {
    this.id = id;
    return this;
  }

  public Client_1 setName(String name) {
    this.name = name;
    return this;
  }

  public Client_1 setAge(int age) {
    this.age = age;
    return this;
  }

  public Client_1 setEmail(String email) {
    this.email = email;
    return this;
  }

  public Client_1 setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Client_1 setCountry(String country) {
    this.country = country;
    return this;
  }

  public Client_1 setActivation(ActivationModel activation) {
    this.activation = activation;
    return this;
  }

  public Client_1 setDeleted(boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  public Client_1 setDateTime(ZonedDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  public Client_1 setCounter(int counter) {
    this.counter = counter;
    return this;
  }
}
