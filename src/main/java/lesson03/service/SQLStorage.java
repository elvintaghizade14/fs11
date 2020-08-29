package lesson03.service;

import lesson03.model.OperationLog;
import lesson03.sql.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class SQLStorage implements Storage {

  @Override
  public void log(OperationLog op) {
    Conn.get().ifPresent(conn -> {
      try {
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO history (a, b, op, r) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, op.a);
        stmt.setInt(2, op.b);
        stmt.setString(3, op.op);
        stmt.setInt(4, op.r);
        stmt.execute();
      } catch (SQLException ex) {
        throw new RuntimeException(ex) ;
      }
    });
  }

  @Override
  public Iterable<OperationLog> get() {
    return Conn.get().flatMap(conn -> {
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
    }).orElse(new ArrayList<>());
  }
}
