package onboarding.problem7;

public enum RecommendType {
  FRIEND(10), VISITOR(1);

  private final int score;

  RecommendType(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }
}
