package onboarding.problem3;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Game369 {
  private static final List<Integer> clapNumbers = List.of(3, 6, 9);
  private int number;

  public void setEndNumber(int number) {
    this.number = number;
  }

  public int getTotalClapping() {
    return IntStream.rangeClosed(1, number)
            .map(this::countClapping)
            .sum();
  }

  private int countClapping(int number) {
    return (int) Stream.of(Integer.toString(number).split(""))
            .mapToInt(Integer::parseInt)
            .filter(n -> clapNumbers.contains(n))
            .count();
  }
}
