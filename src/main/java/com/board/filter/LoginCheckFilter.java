package com.board.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclude", value = "/loginForm.jsp")
})
public class LoginCheckFilter implements Filter {
  String exclude;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    exclude = filterConfig.getInitParameter("exclude");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpSession session = ((HttpServletRequest) request).getSession();
    Object id = session.getAttribute("id");

    if (Objects.isNull(id)) {
      if (exclude.equals(((HttpServletRequest) request).getRequestURI())) {
        chain.doFilter(request, response);
      } else {
        ((HttpServletResponse) response).sendRedirect("/loginForm.jsp");

      }
    } else {
      chain.doFilter(request, response);
    }
  }
}
