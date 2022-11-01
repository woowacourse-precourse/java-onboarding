package onboarding.problem1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Score {
  private OpenBook openBook;

  public Score(OpenBook openBook) {
    this.openBook = openBook;
  }

  public int getOpenBookScore() {
    return Integer.max(getPageScore(openBook.getLeftPage()), getPageScore(openBook.getRightPage()));
  }

  private int getPageScore(int page) {
    return Integer.max(sumOfDigit(page), multiplicationSumOfDigit(page));
  }

  private int sumOfDigit(int page) {
    return getDigitStream(page)
            .reduce(0, Integer::sum);
  }

  private int multiplicationSumOfDigit(int page) {
    return getDigitStream(page)
            .reduce(1, (a, b) -> a * b);
  }

  private IntStream getDigitStream(int page) {
    return Stream.of(Integer.toString(page).split(""))
            .mapToInt(Integer::parseInt);
  }
}
