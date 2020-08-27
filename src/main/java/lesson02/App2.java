package lesson02;

import lesson02.servlet.FileServletFreemarker;
import lesson02.servlet.FileServletFreemarker2;
import lesson02.servlet.FileServletV3Resources;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App2 {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(FileServletV3Resources.class, "/file");
    handler.addServlet(FileServletFreemarker2.class, "/fm");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
