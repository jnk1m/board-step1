package com.board.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
//        @WebInitParam(name = "exclude", value = "/loginForm.jsp;/login.do")
//})
public class LoginCheckFilter implements Filter {
  private Set<String> excludedUrls = new HashSet<>();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    String url = filterConfig.getInitParameter("exclude-urls");
    excludedUrls = Arrays.stream(url.split("\n"))
            .map(String::trim)
            .collect(Collectors.toSet());
//    String initParameter = filterConfig.getInitParameter("exclude");
//    excludeUrls = initParameter.split(";");
//    String url = filterConfig.getInitParameter("exclude-urls");
//    excludedUrls = Arrays.stream(url.split("\n"))
//            .map(String::trim)
//            .collect(Collectors.toSet());
//    exclude[0] = filterConfig.getInitParameter("exclude");
//    exclude[1] = filterConfig.getInitParameter("exclude2");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpSession session = ((HttpServletRequest) request).getSession();
    Object id = session.getAttribute("id");

    if (Objects.isNull(id)) {
      if(excludedUrls.contains(((HttpServletRequest)request).getRequestURI())){
        chain.doFilter(request,response);
      }else{
        ((HttpServletResponse)response).sendRedirect("/loginForm.jsp");
      }
//      for (int i = 0; i < excludeUrls.length; i++) {
////        exclude
//        if (excludeUrls[i].equals(((HttpServletRequest) request).getRequestURI())) {
//          chain.doFilter(request, response);
//        } else {
//          ((HttpServletResponse) response).sendRedirect("/loginForm.jsp");
//
//        }
//      }


    } else {
      chain.doFilter(request, response);
    }
  }
}
