package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if(isFirstOrLastPage(pobi) | isFirstOrLastPage(crong)) {
      return -1;
    }
    if(!isCorrectOrder(pobi) | !isConnectedPage(crong)) {
      return -1;
    }
    if(!isConnectedPage(pobi) | !isConnectedPage(crong)) {
      return -1;
    }
    return getGameResult(getScore(pobi), getScore(crong));
  }

  private static int getGameResult(Integer pobiScore, Integer crongScore) {
    int result = Integer.compare(pobiScore, crongScore);
    if (result == -1) {
      result = 2;
    }
    return result;
  }

  private static int getScore(List<Integer> pages) {
    return pages.stream()
            .map(page -> Integer.max(sumOfDigit(page), multiplicationSumOfDigit(page)))
            .findFirst()
            .get();
  }

  private static boolean isFirstOrLastPage(List<Integer> pages) {
    return pages.stream().anyMatch(page -> page == 1 | page == 400);
  }
  private static boolean isConnectedPage(List<Integer> pages) {
    return pages.get(0) + 1 == pages.get(1);
  }
  private static boolean isCorrectOrder(List<Integer> pages) {
    return pages.get(0) % 2 == 1 & pages.get(1) % 2 == 0;
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