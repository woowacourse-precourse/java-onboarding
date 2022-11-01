package onboarding.problem1;

public class OpenBookGame {

  private Score pobiScore;
  private Score crongScore;

  public OpenBookGame(Score pobiScore, Score crongScore) {
    this.pobiScore = pobiScore;
    this.crongScore = crongScore;
  }

  public int getResult() {
    int result = Integer.compare(pobiScore.getOpenBookScore(), crongScore.getOpenBookScore());
    if (result == -1) {
      result = 2;
    }
    return result;
  }
}
