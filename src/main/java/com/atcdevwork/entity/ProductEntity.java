package com.atcdevwork.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate

public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productName;

  private BigDecimal productPrice;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "product_order",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "order_id")
  )
  private List<OrderEntity> orderList;
}
