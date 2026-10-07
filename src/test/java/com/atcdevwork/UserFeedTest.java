package com.atcdevwork;

import com.atcdevwork.entity.feed.FeedEntity;
import com.atcdevwork.entity.user.UserEntity;
import com.atcdevwork.repository.FeedRepository;
import com.atcdevwork.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserFeedTest {

  @Autowired
  private FeedRepository feedRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  @Transactional
  @Rollback(false)
  void onToManyTest() {
    // 1. New user
    UserEntity user = new UserEntity();
    FeedEntity feed = new FeedEntity();

    user.setUserName("AnhCt1");
    user.setUserEmail("anhct1@gmail.com");

    feed.setTitle("Post 1");
    feed.setDescription("Desc post 1");

    feed.setUser(user);
    user.setFeedList(List.of(feed));

    userRepository.save(user);
    // feedRepository.save(feed);
  }

  @Test
  @Transactional
  void selectOneToManyTest() {
    UserEntity user = userRepository.findById(1L).orElseThrow();
    System.out.println(user);
    System.out.println(user.getFeedList());
  }
}
