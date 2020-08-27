package lesson02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp {
  /**
   * List(1,2,3)
   * =>
   * List(1,10,100,2,20,200,3,30,300)
   */

  private static Stream<Integer> sub(int x) {
    return Stream.of(x, x * 10, x * 100);
  }

  public static void main(String[] args) {
    List<Integer> collect =
        Arrays.asList(1, 2, 3).stream() // Stream<Int>
            .flatMap(x -> Stream.of(x, x * 10, x * 100)) // Stream<Stream<Int>>
            .collect(Collectors.toList());
    System.out.println(collect);
  }

}
