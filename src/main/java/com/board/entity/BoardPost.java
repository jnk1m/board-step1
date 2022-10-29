package com.board.entity;

import java.time.LocalDateTime;

public class BoardPost implements Post{
  @Override
  public long getId() {
    return 0;
  }

  @Override
  public void setId(long id) {

  }

  @Override
  public String getTitle() {
    return null;
  }

  @Override
  public void setTitle(String title) {

  }

  @Override
  public String getContent() {
    return null;
  }

  @Override
  public void setContent(String content) {

  }

  @Override
  public String getWriterUserId() {
    return null;
  }

  @Override
  public void setWriterUserId(String writerUserId) {

  }

  @Override
  public LocalDateTime getWriteTime() {
    return null;
  }

  @Override
  public void setWriteTime(LocalDateTime writeTime) {

  }

  @Override
  public int getViewCount() {
    return 0;
  }

  @Override
  public void increaseViewCount() {

  }
}
