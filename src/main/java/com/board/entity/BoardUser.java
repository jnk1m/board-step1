package com.board.entity;

public class BoardUser implements User{
  String id;
  String password;
  String name;
  String profileFileName;

  public BoardUser(String id, String password, String name, String profileFileName) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.profileFileName = profileFileName;
  }

  @Override
  public String getId() {
    return null;
  }

  @Override
  public void setId(String id) {

  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public void setPassword(String password) {

  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void setName(String name) {

  }

  @Override
  public String getProfileFileName() {
    return null;
  }

  @Override
  public void setProfileFileName(String profileFileName) {

  }
}
