package com.atcdevwork.entity.user;

import com.atcdevwork.entity.cccd.CCCDEntity;
import com.atcdevwork.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
  private String userName;

  @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
  private String userEmail;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  private List<FeedEntity> feedList;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cccd_id")
  private CCCDEntity cccd;
}
