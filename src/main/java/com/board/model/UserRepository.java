package com.board.model;

import com.board.entity.User;

import java.util.List;

public interface UserRepository {
  void add(User user);
  void modify(User user);
  User remove(String id);

  User getUser(String id);
  List<User> getUsers();
}
