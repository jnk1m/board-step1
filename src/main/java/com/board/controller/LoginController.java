package com.board.controller;

import com.board.domain.UserRepository;
import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class LoginController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String method = req.getMethod();

    if (method.equals("GET")) {
      return doGet(req, resp);
    } else if (method.equals("POST")) {
      return doPost(req, resp);
    }
    return "postList.jsp";
  }

  protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
    HttpSession session = req.getSession();
    String id = (String) session.getAttribute("id");

    if (Objects.isNull(id)) {
      return "redirect:/loginForm.jsp";
    } else if (id.equals("admin")) {
      return "redirect:/adminPage.jsp";
    } else {
      return "redirect:/postList.jsp";
    }
  }

  protected String doPost(HttpServletRequest req, HttpServletResponse resp) {

    UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    User user = userRepository.getUser(id); // 해당 키로 찾을 밸류가 없으면 null을 반환함

    if (Objects.isNull(user)) {
      return "redirect:/loginForm.jsp";
    }

    String requestPassword = user.getPassword();

    if (requestPassword.equals(password)) {
      HttpSession session = req.getSession();
      session.setAttribute("id", id);
      if (id.equals("admin")) { //아이디가 admin이며 관리자 페이지로
        return "redirect:/adminPage.jsp";
      }
      return "redirect:/postList.jsp"; //일반 사용자면 게시글 목록으로
    } else {
      return "redirect:/loginForm.jsp"; //비밀번호가 같지 않다면 로그인 폼으로
    }
  }
}
