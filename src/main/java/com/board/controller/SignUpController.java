package com.board.controller;

import com.board.domain.UserRepository;
import com.board.entity.BoardUser;
import com.board.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
public class SignUpController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    String paramId = req.getParameter("id");
    String paramPassword = req.getParameter("password");
    String paramName = req.getParameter("name");

    UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

    List<User> users = userRepository.getUsers(); //아이디 중복체크
    for (User user : users) {
      if (paramId.equals(user.getId())) {
        req.setAttribute("existsId",paramId);
        return "redirect:/signUpForm.jsp"; //이미 있는 아이디인 경우 회원가입 폼으로 리다이렉트
      }
    }
    userRepository.add(new BoardUser(paramId,paramPassword,paramName));

    return "redirect:/loginForm.jsp";
  }
}
