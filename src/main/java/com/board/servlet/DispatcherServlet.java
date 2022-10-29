package com.board.servlet;

import com.board.controller.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {
  private static final String REDIRECT_PREFIX = "redirect:";

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Command command = resolveServlet(req.getServletPath());
      String view = command.execute(req, resp);
      log.info("@@@@@@@"+view+"@@@@@");

      if (view.startsWith(REDIRECT_PREFIX)) {
        resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
      } else {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
      }
    } catch (Exception e) {
      log.error(" ", e);
    }
  }

  private Command resolveServlet(String servletPath) {
    Command command = null;
    if ("/login.do".equals(servletPath)) {
      command = new LoginController();
    } else if ("/language.do".equals(servletPath)) {
      command = new LanguageController();
    } else if ("/signUp.do".equals(servletPath)) {
      command = new SignUpController();
    } else if ("/eachUser.do".equals(servletPath)) {
      command = new ViewEachUserController();
    }

    return command;
  }
}
