package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServletV1 extends HttpServlet {

  /**
   * http://localhost:8080/file
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    File file = new File("1.html");
    try (BufferedReader br = new BufferedReader(new FileReader(file));
         PrintWriter w = resp.getWriter()) {
      String content = br.lines().collect(Collectors.joining("\n"));
      w.println(content);
    }
  }
}
