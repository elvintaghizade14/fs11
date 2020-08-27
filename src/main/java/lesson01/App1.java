package lesson01;

import lesson01.service.CalcService;
import lesson01.servlet.CalcServlet;
import lesson01.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App1 {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/");

    CalcService calcService = new CalcService();
    CalcServlet calcServlet = new CalcServlet(calcService);
    ServletHolder calcHolder = new ServletHolder(calcServlet);

    handler.addServlet(calcHolder, "/calc");
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
