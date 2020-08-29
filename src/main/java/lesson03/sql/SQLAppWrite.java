package lesson03.sql;

import lesson03.model.OperationLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class SQLAppWrite {
  public static void main(String[] args) throws SQLException {
    Conn.get().ifPresent(conn -> {
      try {
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO history (a, b, op, r) VALUES (?, ?, ?, ?)");
        stmt.setInt(1,100);
        stmt.setInt(2,200);
        stmt.setString(3,"+");
        stmt.setInt(4,300);
        stmt.execute();
      } catch (SQLException ex) {
        throw new RuntimeException(ex) ;
      }
    });
  }
}
