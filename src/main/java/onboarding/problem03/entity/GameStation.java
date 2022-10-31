package onboarding.problem03.entity;

import onboarding.problem03.infra.GameNumberOutOfRange;

public class GameStation {

  private int number;

  private GameStation(int number) {
    if (number < 1 || number > 10000) {
      throw new GameNumberOutOfRange();
    }
    this.number = number;
  }

  public static GameStation from(int number) {
    return new GameStation(number);
  }
}
