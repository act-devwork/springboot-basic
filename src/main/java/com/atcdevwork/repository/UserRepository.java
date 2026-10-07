package com.atcdevwork.repository;

import com.atcdevwork.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
  // use pageable
  Page<UserEntity> findByUserName(String name, Pageable pageable);
  Page<UserEntity> findByUserNameContaining(String name, Pageable pageable);

  // find userName vs userEmail
  // where userName = ?1 and userEmail = ?1
  UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

  //  Where userName LIKE %?
  List<UserEntity> findByUserNameStartingWith(String userName);

  //  Where userName LIKE ?%
  List<UserEntity> findByUserNameEndingWith(String userName);

  // Where id < 1
  List<UserEntity> findByIdLessThan(Long id);

  // RAW JPQL
  @Query("SELECT u from UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
  UserEntity findMaxId();

  @Query("SELECT u from UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
  List<UserEntity> getUserEntityBy(String userName, String userEmail);

  @Query("SELECT u from UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
  List<UserEntity> getUserEntityByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);


  // Update & Delete
  @Modifying
  @Query("UPDATE UserEntity u SET u.userName = :userName")
  @Transactional
  int updateUserName(@Param("userName") String userName);

  // Native query
  @Query(value = "SELECT COUNT(id) FROM users", nativeQuery = true)
  long getTotalUsers();
}
