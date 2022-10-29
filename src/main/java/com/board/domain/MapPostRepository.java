package com.board.domain;

import com.board.entity.Post;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MapPostRepository implements PostRepository {
  ConcurrentHashMap<String, Post> postMap = new ConcurrentHashMap<>();

  @Override
  public long register(Post post) {
    return 0;
  }

  @Override
  public void modify(Post post) {

  }

  @Override
  public Post remove(long id) {
    return null;
  }

  @Override
  public Post getPost(long id) {
    return null;
  }

  @Override
  public List<Post> getPosts() {
    return null;
  }
}
