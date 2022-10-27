package com.board.entity;

import java.time.LocalDateTime;

public interface Post {
  long getId();
  void setId(long id);

  String getTitle();
  void setTitle(String title);

  String getContent();
  void setContent(String content);

  String getWriterUserId();
  void setWriterUserId(String writerUserId);

  LocalDateTime getWriteTime();
  void setWriteTime(LocalDateTime writeTime);

  int getViewCount();
  void increaseViewCount();
}
