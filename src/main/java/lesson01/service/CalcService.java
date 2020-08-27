package lesson01.service;

import java.util.Optional;

public class CalcService {
  private final Calculator calc = new Calculator();

  public Optional<Integer> add(
      Optional<Integer> a,
      Optional<Integer> b) {
    return a.flatMap(ai ->
        b.map(bi ->
            calc.add(ai, bi)
        )
    );
  }
}
