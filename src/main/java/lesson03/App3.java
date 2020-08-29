package lesson03;

import lesson03.servlet.CalcServlet;
import lesson03.servlet.IndexServlet;
import lesson03.servlet.RedirectServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App3 {
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
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(IndexServlet.class, "/home");
    handler.addServlet(CalcServlet.class, "/calc");



    handler.addServlet(RedirectServlet.class, "/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
