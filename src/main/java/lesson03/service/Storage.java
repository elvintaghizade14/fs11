package lesson03.service;

import lesson03.domain.OperationLog;

public interface Storage {
  void log(OperationLog op);
  Iterable<OperationLog> get();
}
