package com.board.domain;

import com.board.entity.Post;

import java.util.List;

public interface PostRepository {
  long register(Post post);
  void modify(Post post);
  Post remove(long id);

  Post getPost(long id);
  List<Post> getPosts();
}
