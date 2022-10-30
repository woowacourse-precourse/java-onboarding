package onboarding;

import onboarding.problem1.OpenBookGame;
import onboarding.problem1.OpenBook;
import onboarding.problem1.Score;

import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    OpenBook pobiOpenBook = OpenBook.fromList(pobi);
    OpenBook crongOpenBook = OpenBook.fromList(crong);

    try {
      pobiOpenBook.validate();
      crongOpenBook.validate();
    } catch (IllegalArgumentException e) {
      return -1;
    }

    OpenBookGame game = new OpenBookGame(new Score(pobiOpenBook), new Score(crongOpenBook));
    return game.getResult();
  }
}