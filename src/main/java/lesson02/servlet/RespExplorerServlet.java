package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

public class RespExplorerServlet extends HttpServlet {

  /**
   * http://localhost:8080/file
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws IOException, ServletException {
    PrintWriter w = rs.getWriter();
    ServletOutputStream os = rs.getOutputStream();
    rs.sendRedirect("/abc2");
    rs.addCookie(new Cookie("a","5"));
    rs.addHeader("SET COOKIE", "A=5");
    rs.setStatus(301);
  }
}
