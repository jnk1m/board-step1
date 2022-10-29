package com.board.domain;

import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapUserRepository implements UserRepository {

  ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

  @Override
  public void add(User user) {
    userMap.put(user.getId(), user);
  }

  @Override
  public void modify(User user) {
    /*
    얘는 레포지토리고 여기는 진짜 디비 커넥션만 관리하는 곳.
    여기서 할만한 로직이라곤 포스트 레포지토리에서 아이디 숫자 하나씩 올라가는 그런거..만 처리하는 곳이다
    validation을 할거면 콘트롤러에서 하기
     */
    userMap.put(user.getId(), user);
  }

  @Override
  public User remove(String id) {
    return userMap.remove(id);
  }

  @Override
  public User getUser(String id) {
//    User user = userMap.get(id);
//    log.info("map "+id); //확인용
//    log.info("map "+user.getName());

    return userMap.get(id);
  }

  @Override
  public List<User> getUsers() {
    return new ArrayList<>(userMap.values());
  }
}
