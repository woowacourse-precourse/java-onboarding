package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    // Todo comare 함수를 구현하거나 따로 함수를 만들어서 제대로 된 결과를 리턴할 수 있도록 하기
    return 1;
  }

  private static int getScore(List<Integer> person) {
    return person.stream()
            .map(page -> Integer.max(sumOfDigit(page), multiplicationSumOfDigit(page)))
            .findFirst()
            .get();
  }

  private static int sumOfDigit(Integer page) {
    return getDigitStream(page)
            .reduce(0, Integer::sum);
  }

  private static int multiplicationSumOfDigit(Integer page) {
    return getDigitStream(page)
            .reduce(1, (a, b) -> a * b);
  }

  private static IntStream getDigitStream(Integer page) {
    return Stream.of(Integer.toString(page).split(""))
            .mapToInt(Integer::parseInt);
  }
}