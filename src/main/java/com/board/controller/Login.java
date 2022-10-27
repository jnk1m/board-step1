package com.board.controller;

import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class Login implements Command{
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    log.info(getClass().getSimpleName()+"!!!!!!!!");

    String method = req.getMethod();

    if(method.equals("GET")){
      return doGet(req,resp);
    } else if (method.equals("POST")) {
      return doPost(req,resp);
    }
    return "postList.jsp";
  }

  protected String doGet(HttpServletRequest req, HttpServletResponse resp){
    log.info(getClass().getSimpleName()+"!!!!!!!!");

    HttpSession session = req.getSession();
    String id = (String)session.getAttribute("id");

    if(Objects.isNull(id)) {
      return "redirect:/loginForm.jsp";
    } else if (id.equals("admin")) {
      return "redirect:/adminPage.jsp";
    }else{
      return "redirect:/postList.jsp";
    }
  }

  protected String doPost(HttpServletRequest req, HttpServletResponse resp){
    log.info(getClass().getSimpleName()+"!!!!!!!!");

    User user = (User)req.getServletContext().getAttribute("user");

    String requestId = user.getId();
    String requestPassword = user.getPassword();

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    if(requestId.equals(id) && requestPassword.equals(password)){
      HttpSession session = req.getSession();
      session.setAttribute("id",id);
      if (id.equals("admin")) {
        return "redirect:/adminPage.jsp";
      }
      return "redirect:/PostList.jsp";
    }else {
      return "redirect:/loginForm.jsp";
    }
  }
}
