package lesson01.servlet;


import lesson01.service.CalcService;
import lesson01.util.Params;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

  private final CalcService calc;

  public CalcServlet(CalcService calc) {
    this.calc = calc;
  }

  /**
   * http://localhost:8080/calc?a=5&b=6
   *
   * http://localhost:8080/calc?a=5&a=6&a=7
   * Map<String, String[]> parameterMap = req.getParameterMap();
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("GET => /calc");

    Optional<Integer> a = Params.getIntParam("a", req);
    Optional<Integer> b = Params.getIntParam("b", req);
    Optional<Integer> c = Params.getIntParam("c", req);

    Optional<String> ab = calc.add(a, b).map(String::valueOf);
    try (PrintWriter w = resp.getWriter()) {
      w.println(a);
      w.println(b);
      w.println(c);
      w.println(ab.orElse("No values"));
      w.println("Calc Servlet (GET)");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("POST => /calc");

    Optional<Integer> a = Params.getIntParam("a", req);
    Optional<Integer> b = Params.getIntParam("b", req);

    try (PrintWriter w = resp.getWriter()) {
      w.println(a);
      w.println(b);
      w.println(calc.add(a, b).map(String::valueOf).orElse("No values"));
      w.println("Calc Servlet (POST)");
    }

  }
}
