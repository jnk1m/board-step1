package com.board;

import com.board.entity.BoardUser;
import com.board.entity.Post;
import com.board.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebListener
public class WebAppListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {

    List<User> userList = new ArrayList<>();
    List<User> synchronizedUserList = Collections.synchronizedList(userList);

    synchronizedUserList.add(new BoardUser("admin","12345","관리자","/"));
    sce.getServletContext().setAttribute("userList",synchronizedUserList);

    List<Post> postList = new ArrayList<>();
    List<Post> synchronizedPostList = Collections.synchronizedList(postList);
    sce.getServletContext().setAttribute("postList",synchronizedPostList);
  }
}
