package lesson01;

import java.util.Optional;

public class OptionalApp {
  public static void main(String[] args) {
    /**
     * map: map(f: A => B)
     * flatMap(f: A => Optional<B>)
     */

    Optional<Integer> i1 = Optional.of(1);
    Optional<Integer> i2 = i1.map(a -> a + 1);

    Optional<Optional<Integer>> i11 = i1.map(a -> Optional.of(a + 1));
    Optional<Integer> i111 = i1.flatMap(a -> Optional.of(a + 1));
    /**
     * flatMap(f) === flatten(map(f))
     * flatten: Optional<Optional<A>> => Optional<A>
     */

  }
}
