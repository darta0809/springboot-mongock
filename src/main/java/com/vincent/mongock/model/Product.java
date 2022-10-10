package com.vincent.mongock.model;

import com.vincent.mongock.MongockApplication;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = MongockApplication.PRODUCTS_COLLECTION_NAME)
public class Product {

  @Id
  private ObjectId id;

  @Field("description")
  private String description;

  @Field("stock")
  private int stock;

  @Field("price")
  private double price;

  public Product() {
  }

  public Product(String description, int stock, double price) {
    this();
    this.description = description;
    this.stock = stock;
    this.price = price;
  }

  // setters returning 'this' for fluent use in stream. Shouldn't be taken as precedent
  public Product setId(ObjectId id) {
    this.id = id;
    return this;
  }

  public Product setDescription(String description) {
    this.description = description;
    return this;
  }

  public Product setStock(int stock) {
    this.stock = stock;
    return this;
  }

  public Product setPrice(double price) {
    this.price = price;
    return this;
  }
}
