package com.board.servlet;

import com.board.controller.Command;
import com.board.controller.Login;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
  private static final String REDIRECT_PREFIX = "redirect:";

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try{
      Command command = resolveServlet(req.getServletPath());
      String view = command.execute(req,resp);

      if(view.startsWith(REDIRECT_PREFIX)){
        resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
      }else {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
      }
    }catch (Exception e){
      log.error(" ",e);
    }
  }

  private Command resolveServlet(String servletPath){
    Command command = null;

    if("login.do".equals(servletPath)){
      command = new Login();
    }

    return command;
  }
}
