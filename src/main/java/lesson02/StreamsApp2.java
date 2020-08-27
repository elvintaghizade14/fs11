package lesson02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp2 {
  /**
   * List(1,2,3)
   * =>
   * List(1,10,100,2,20,200,3,30,300)
   */

  public static void main(String[] args) {
    LinkedList<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6) // Stream<Int>
        .flatMap(x -> (x % 2 == 0) ? Stream.of(x) : Stream.empty())
        .collect(Collectors.toCollection(LinkedList::new));

    System.out.println(collect);
  }

}
