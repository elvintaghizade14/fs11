package lesson03.model;

public class OperationLog {
  public final int a;
  public final int b;
  public final String op;
  public final int r;

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
