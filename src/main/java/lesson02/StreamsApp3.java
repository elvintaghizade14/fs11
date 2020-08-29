package lesson02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsApp3 {
  /**
   * List(1,2,3)
   * =>
   * List(1,10,100,2,20,200,3,30,300)
   */

  public static void main(String[] args) {
    int[][] x = {
        {1,2,3,4},
        {5,6},
        {},
        {7,8,9,10}
    };
    Stream<int[]> s1 = Arrays.stream(x);
    Stream<Integer> s2a = s1.flatMap(a -> Arrays.stream(a).boxed());

    IntStream s2 = s1.flatMapToInt(a -> Arrays.stream(a));
    int[] flattened = s2.toArray();
    Stream<Integer> s3 = s2.boxed();
    List<Integer> collected = s3.collect(Collectors.toList());
    collected.forEach(System.out::println);

  }

}
