package com.board;

import com.board.domain.MapPostRepository;
import com.board.domain.MapUserRepository;
import com.board.domain.UserRepository;
import com.board.entity.BoardUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {

    UserRepository userRepository = new MapUserRepository();
    userRepository.add(new BoardUser("admin", "12345", "관리자"));

    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("userRepository", userRepository);
    servletContext.setAttribute("postRepository", new MapPostRepository());
  }
}
