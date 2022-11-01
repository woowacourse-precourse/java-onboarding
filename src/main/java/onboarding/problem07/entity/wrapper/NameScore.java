package onboarding.problem07.entity.wrapper;

public class NameScore {

  private Name user;
  private int score;

  private NameScore(Name user) {
    this.user = user;
    this.score = 0;
  }

  public static NameScore from(Name user) {
    return new NameScore(user);
  }

  public void alreadyFriend() {
    score = -1;
  }

  public void newFriend() {
    score += 10;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NameScore)) {
      return false;
    }

    NameScore nameScore = (NameScore) o;

    return user != null ? user.equals(nameScore.user) : nameScore.user == null;
  }

  @Override
  public int hashCode() {
    return user != null ? user.hashCode() : 0;
  }
}
