package lesson03.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Conn {

  public static Optional<Connection> get(
      String url,
      String username,
      String password
  ) {
    try {
      return Optional.of(DriverManager.getConnection(url, username, password));
    } catch (SQLException ex) {
      return Optional.empty();
    }
  }

  public static Optional<Connection> get() {
    return get(
        "jdbc:postgresql://localhost:5432/fs11",
        "postgres",
        "secret"
    );
  }

}
