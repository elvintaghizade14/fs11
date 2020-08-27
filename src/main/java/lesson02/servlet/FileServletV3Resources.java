package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileServletV3Resources extends HttpServlet {

  /**
   * http://localhost:8080/file
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (ServletOutputStream os = resp.getOutputStream()) {
      Files.copy(
          Paths.get(this.getClass().getClassLoader().getResource("2.html").toURI()),
          os
      );
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
