package lesson03.servlet;

import lesson02.util.TemplateEngine;
import lesson03.domain.OperationLog;
import lesson03.service.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class HistoryServlet extends HttpServlet {
  private final Storage storage;
  private final TemplateEngine engine = TemplateEngine.folder("content");

  public HistoryServlet(Storage storage) {
    this.storage = storage;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Stream<OperationLog> stream1 = StreamSupport.stream(
        storage.get().spliterator(),
        false
    );
    Stream<String> stream2 = stream1.map(OperationLog::toString);
    List<String> operations = stream2.collect(Collectors.toList());

    HashMap<String, Object> data = new HashMap<>();
    data.put("ops", operations);

    engine.render("history.ftl", data, resp);
  }
}
