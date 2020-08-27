package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class ReqExplorerServlet extends HttpServlet {

  /**
   * http://localhost:8080/file
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String a = req.getParameter("a"); // NULL !
    Map<String, String[]> parameterMap = req.getParameterMap();
    String authentication = req.getHeader("Authentication");
    Cookie[] cookies = req.getCookies();
    String method = req.getMethod();
    Collection<Part> parts = req.getParts();
    for (Part p: parts) {
      p.getContentType();
      p.getInputStream();
      p.getSubmittedFileName();
      p.getSize();
    }
    String pathInfo = req.getPathInfo(); // w.o params.
    String queryString = req.getQueryString();// with params. http......&x=5
    String contextPath = req.getContextPath();

    // body for PUT, POST, etc
    ServletInputStream inputStream = req.getInputStream();

  }
}
