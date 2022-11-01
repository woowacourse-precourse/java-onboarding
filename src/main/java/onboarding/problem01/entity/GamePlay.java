package onboarding.problem01.entity;

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

  public Integer play() {
    // check pobi list crong list not -1
    if (pobi.isNotBook() || crong.isNotBook()) {
      return -1;
    }

    // play game logic
    Integer pobiGameValue = pobi.gameValue();
    Integer crongGameValue = crong.gameValue();

    if (pobiGameValue > crongGameValue) {
      return 1;
    } else if (pobiGameValue < crongGameValue) {
      return 2;
    } else if (pobiGameValue == crongGameValue) {
      return 0;
    }
    return -1;
  }
}
