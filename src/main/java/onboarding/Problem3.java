package onboarding;

public class Problem3 {

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

  public static int solution(int number) {
    return getGameNumberCount(number);
  }

  private static int getGameNumberCount(int number) {
    int targetPosLeftNumber = 1;
    int targetPosRightNumber, targetPosNumber;
    int digit = 1;

    int result = 0;
    while (targetPosLeftNumber != 0) {
      targetPosLeftNumber = (number / digit) / 10;
      targetPosRightNumber = number % digit;
      targetPosNumber = (number / digit) % 10;

      for (GameNumber gameNumber : GameNumber.values()) {
        if (targetPosNumber > gameNumber.getValue()) {
          result += (targetPosLeftNumber + 1) * digit;
        } else if (targetPosNumber < gameNumber.getValue()) {
          result += targetPosLeftNumber * digit;
        } else {
          result += targetPosLeftNumber * digit + (targetPosRightNumber + 1);
        }
      }

      digit *= 10;
    }
    return result;
  }

}
