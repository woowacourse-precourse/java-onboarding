package onboarding;

public class Problem3 {

  static Game game = new Game();

  public static int solution(int number) {
    return game.start(number);
  }

  enum GameNumber {
    THREE(3), SIX(6), NINE(9);

    GameNumber(int value) {
      this.value = value;
    }

    private final int value;

    public int getValue() {
      return this.value;
    }
  }

  static class Game {

    private int posLeftNumber;
    private int posRightNumber;
    private int posNumber;
    private int digit;

    public Game() {
      posLeftNumber = 1;
      digit = 1;
    }

    public int start(int number) {
      posLeftNumber = 1;
      digit = 1;

      int total = 0;
      while (posLeftNumber != 0) {
        posLeftNumber = (number / digit) / 10;
        posRightNumber = number % digit;
        posNumber = (number / digit) % 10;

        total += countInDigits();

        digit *= 10;
      }
      return total;
    }

    private int countInDigits() {
      int result = 0;
      for (GameNumber gameNumber : GameNumber.values()) {
        result += countForGameNumber(gameNumber);
      }
      return result;
    }

    private int countForGameNumber(GameNumber gameNumber) {
      if (posNumber > gameNumber.getValue()) {
        return (posLeftNumber + 1) * digit;
      }
      if (posNumber < gameNumber.getValue()) {
        return posLeftNumber * digit;
      }
      return posLeftNumber * digit + (posRightNumber + 1);
    }
  }

}
