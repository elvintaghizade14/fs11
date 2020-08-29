package lesson03.service;

import lesson03.domain.OperationLog;

import java.util.ArrayList;

public class InMemoryStorage implements Storage {

  private final ArrayList<OperationLog> data = new ArrayList<>();

  @Override
  public void log(OperationLog op) {
    data.add(op);
  }

  @Override
  public Iterable<OperationLog> get() {
    return data;
  }

}
