package lesson03.sql;

import lesson03.model.OperationLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class SQLAppRead {
  /**
   * server: localhost
   * db_name: fs11
   * port: 5432  (pg) / 3306 (mysql)
   * username: postgres (pg) / root (mysql)
   * password: secret
   *
   */
  public static void main(String[] args) {
    Conn.get().flatMap(conn -> {
      try {
        PreparedStatement stmt = conn.prepareStatement("select * from history");
        ResultSet rset = stmt.executeQuery();
        ArrayList<OperationLog> opll = new ArrayList<>();
        while (rset.next()) {
          int a = rset.getInt("a");
          int b = rset.getInt("b");
          int r = rset.getInt("r");
          String op = rset.getString("op");
          OperationLog opl = new OperationLog(a, b, op, r);
          opll.add(opl);
        }
        return Optional.of(opll);
      } catch (SQLException throwables) {
        return Optional.empty();
      }
    }).ifPresent(al -> al.forEach(System.out::println));
  }
}
