package lesson03.domain;

public class OperationLog {
  private final int a;
  private final int b;
  private final String op;
  private final int r;

  public OperationLog(int a, int b, String op, int r) {
    this.a = a;
    this.b = b;
    this.op = op;
    this.r = r;
  }

  @Override
  public String toString() {
    return String.format(
        "[%d %s %d = %d]", a, op, b, r);
  }
}
