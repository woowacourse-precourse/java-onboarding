package onboarding;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem3 {
  public static int solution(int number) {
    return 1;
  }

  public static int countIncludeGameNumber(int number) {
    return (int) Stream.of(Integer.toString(number).split(""))
            .mapToInt(Integer::parseInt)
            .filter(n -> n == 3 | n == 6 || n == 9)
            .count();
  }
}
