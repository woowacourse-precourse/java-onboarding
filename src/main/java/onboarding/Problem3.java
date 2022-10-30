package onboarding;

import onboarding.problem3.Game369;

public class Problem3 {

  public static int solution(int number) {
    Game369 game = new Game369();
    game.setEndNumber(number);
    return game.getTotalClapping();
  }
}
