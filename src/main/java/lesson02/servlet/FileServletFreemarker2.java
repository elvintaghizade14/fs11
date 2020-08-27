package lesson02.servlet;

import lesson02.util.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileServletFreemarker2 extends HttpServlet {

  /**
   * http://localhost:8080/fm
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    TemplateEngine engine = TemplateEngine.folder("content");

    HashMap<String, Object> data = new HashMap<>();
    data.put("name", "Jim");

    List<Student> ss = Arrays.asList(
        new Student("Jim", 33, "FS11"),
        new Student("Jack", 34, "FS12"),
        new Student("James", 35, "FS13")
    );

    data.put("students", ss);
    data.put("total", ss.size());

    engine.render("dynamic2.ftl", data, resp);
  }
}
