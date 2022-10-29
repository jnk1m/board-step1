package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LanguageController implements Command{
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String language = req.getParameter("language");
    req.getSession().setAttribute("language",language);
    return "redirect:/loginForm.jsp";
  }
}
