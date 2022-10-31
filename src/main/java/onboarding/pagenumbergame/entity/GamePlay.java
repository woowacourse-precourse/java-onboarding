package onboarding.pagenumbergame.entity;

import java.util.List;

public class GamePlay {

  private Book pobi;
  private Book crong;

  private GamePlay(List<Integer> pobiInt, List<Integer> crongInt) {
    pobi = Book.of(pobiInt);
    crong = Book.of(crongInt);
  }

  public static GamePlay of(List<Integer> pobi, List<Integer> crong) {
    return new GamePlay(pobi, crong);
  }
}
