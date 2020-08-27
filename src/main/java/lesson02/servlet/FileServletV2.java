package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileServletV2 extends HttpServlet {

  /**
   * http://localhost:8080/file
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    ServletOutputStream outputStream = resp.getOutputStream();

    try (ServletOutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("1.html"), os);
    }
  }
}
