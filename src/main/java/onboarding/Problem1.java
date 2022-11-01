package onboarding;

import onboarding.problem1.OpenBookGame;
import onboarding.problem1.OpenBook;
import onboarding.problem1.Score;

import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobiPages, List<Integer> crongPages) {
    OpenBook pobiOpenBook = OpenBook.fromPages(pobiPages);
    OpenBook crongOpenBook = OpenBook.fromPages(crongPages);

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