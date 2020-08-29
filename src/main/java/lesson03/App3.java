package lesson03;

import lesson03.service.InMemoryStorage;
import lesson03.service.Storage;
import lesson03.servlet.CalcServlet;
import lesson03.servlet.HistoryServlet;
import lesson03.servlet.IndexServlet;
import lesson03.servlet.RedirectServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App3 {
  /*
    public void doSomething(ArrayList<Integer> data)
    public void doSomething(List<Integer> data)
    public void doSomething(Collection<Integer> data)
    public void doSomething(Iterable<Integer> data) {
      data.remove();
      data.add();
    }
  */

  /**
   * GET => "/" => index.html
   *   => input A, B, Op
   *     => GET => show form
   *     => doCalc => POST
   *       => result
   *   => history
   *     => calc
   *
   *  GET "/*" => redirect => "/calc"
   */

  public static void main(String[] args) throws Exception {
    Storage storage = new InMemoryStorage();

    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(IndexServlet.class, "/home");
    handler.addServlet(new ServletHolder(
        new CalcServlet(storage)), "/calc");
    handler.addServlet(new ServletHolder(
        new HistoryServlet(storage)), "/history");

    handler.addServlet(RedirectServlet.class, "/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
