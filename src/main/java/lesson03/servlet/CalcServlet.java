package lesson03.servlet;

import lesson01.service.CalcService;
import lesson01.util.Params;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * /calc. POST: /calc ---- OK
 *
 * /extra/calc. POST /calc -> /calc --> ERR
 * /extra/calc. POST calc -> /extra/calc --> OK
 *
 */
public class CalcServlet extends HttpServlet {

  private final CalcService calc = new CalcService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (ServletOutputStream os = resp.getOutputStream()) {
      URI uri = this.getClass().getClassLoader()
          .getResource("calc.html").toURI();
      Path path = Paths.get(uri);
      Files.copy(path, os);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private String represent(int a, int b, String op, int r) {
    return String.format("%d %d = %d", a, b, r);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Optional<Integer> a = Params.getIntParam("a", req);
    Optional<Integer> b = Params.getIntParam("b", req);
    Optional<String> ops = Params.getStrParam("operation", req);
    Optional<String> result = a.flatMap(ai ->
        b.flatMap(bi ->
            ops.flatMap(op -> {
              switch (op) {
                case "plus":  return calc.add(a, b);
                case "minus": return calc.sub(a, b);
                default:      return Optional.empty();
              }
            })
                .map(r -> represent(ai, bi, "", r))
        )
    );

    try (PrintWriter w = resp.getWriter()) {
      w.println(result.orElse("Missed data"));
    }
  }
}
