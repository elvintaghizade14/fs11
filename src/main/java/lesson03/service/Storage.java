package lesson03.service;

import lesson03.model.OperationLog;

public interface Storage {
  void log(OperationLog op);
  Iterable<OperationLog> get();
}
