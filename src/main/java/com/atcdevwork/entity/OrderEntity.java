package com.atcdevwork.entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
@DynamicInsert
@DynamicUpdate

public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int userId;

  @ManyToMany(mappedBy = "orderList")
  @ToString.Exclude
  private List<ProductEntity> productList;
}
