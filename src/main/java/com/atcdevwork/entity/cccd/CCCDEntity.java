package com.atcdevwork.entity.cccd;

import com.atcdevwork.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "cccd")
@DynamicInsert
@DynamicUpdate
public class CCCDEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 12)
  private String numberCCCD;
}
