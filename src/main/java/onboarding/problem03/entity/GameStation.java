package onboarding.problem03.entity;

import onboarding.problem03.infra.exception.GameNumberOutOfRange;
import onboarding.problem03.infra.util.MultipleThreeGenerator;

public class GameStation {

  private int number;
  private int count;

  private GameStation(int number) {
    if (number < 1 || number > 10000) {
      throw new GameNumberOutOfRange();
    }
    this.number = number;
    gamePlay();
  }

  public static GameStation from(int number) {
    return new GameStation(number);
  }

  private void gamePlay() {
    for (int i = 1; i < number+1; i++) {
      count += MultipleThreeGenerator.countScore(i);
    }
  }
  public int gameScore() {
    return count;
  }
}
