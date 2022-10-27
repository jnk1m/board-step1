package com.board.domain;

import com.board.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MapUserRepository implements UserRepository {

  ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

  @Override
  public void add(User user) {
    userMap.put(user.getId(), user);
  }

  @Override
  public void modify(User user) {
    /*
    아이디를 가져와서
    아이디가 같다면
    put을 할 수 있게?
    뭐랑 같으면....?
    add랑 완전 똑같으면 안되고 뭐 검증하는 부분이 있어야할 거 같은데
     */
    userMap.put(user.getId(), user);
  }

  @Override
  public User remove(String id) {

    return null;
  }

  @Override
  public User getUser(String id) {
    return userMap.get(id);
  }

  @Override
  public List<User> getUsers() {
    List<User> userList = new ArrayList<>();
    for (String userKey : userMap.keySet()) {
      userList.add(userMap.get(userKey));
    }
    return userList;
  }
}
